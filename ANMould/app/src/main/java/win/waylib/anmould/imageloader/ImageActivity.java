package win.waylib.anmould.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import win.waylib.anmould.R;
import win.waylib.anmould.adapter.CommonListAdapter;
import win.waylib.anmould.adapter.ViewHolder;
import win.waylib.anmould.base.BaseActivity;
import win.waylib.anmould.utils.BitmapUtil;

public class ImageActivity extends BaseActivity {
	@Bind(R.id.lvImage)
	ListView lvImage;
	@Bind({ R.id.ivHead, R.id.ivHead2, R.id.ivHead3, R.id.ivHead4, R.id.ivHead5 })
	List<ImageView> ivHeads;

	@Override
	protected void onCreate() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_image);
	}

	@Override
	protected void initData() {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<>();
		final String[] urlArr = new String[] { "http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg",
				"https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=881287285,385447056&fm=58",
				"https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3415372198,2864505025&fm=58",
				"https://ss0.baidu.com/73t1bjeh1BF3odCf/it/u=422838827,2960090111&fm=96&s=2EF1E8161692F790DCBD9CE002003039",
				"http://a.hiphotos.baidu.com/baike/w%3D268%3Bg%3D0/sign=c96039673bc79f3d8fe1e336829aaa2c/6a63f6246b600c338719a2501a4c510fd8f9a1c1.jpg"};
		String gifUrl="http://media3.giphy.com/avatars/slimjimstudios/7JllQG4ebw2v.gif";
		String gifUrl2="http://image.haha.mx/2012/12/29/middle/693800_590e7795db0a1b524c2276cf030e4bf7_1356762332.gif";
		
		for (int i = 0; i < urlArr.length; i++) {
			list.add(urlArr[i]);
		}
		CommonListAdapter adapter = new CommonListAdapter<String>(this, list, R.layout.item_image_act__listview_lay) {

			@Override
			public void convert(ViewHolder helper, String item, int position) {
				// TODO Auto-generated method stub
				helper.setImageByUrl(getApplicationContext(), R.id.iv, urlArr[position]);
			}

		};
		lvImage.setAdapter(adapter);

		// -------------------------------------------
		// 滚动加载，不滚动时不加载,提高listview效率：
//		Glide.with(context).resumeRequests();
//		Glide.with(context).pauseRequests();
		
		// 1.加载网络图片
		Glide.with(getApplicationContext())
				.load("http://image.haha.mx/2012/12/29/middle/693800_590e7795db0a1b524c2276cf030e4bf7_1356762332.gif")
				.error(R.drawable.qrcode) // 加载错误显示图片
				.placeholder(R.drawable.cat) // 占位图片
				.centerCrop() // 使图片的两个坐标（宽、高）都大于等于 相应的视图坐标（负的内边距）。图像则位于视图的中央
				.diskCacheStrategy(DiskCacheStrategy.ALL) // 让Glide既缓存全尺寸又缓存其他尺寸：
//				.transform(new BitmapTransformation()) 
				.crossFade()  //淡入淡出动画效果
				.into(ivHeads.get(0)); // 设置目标view
		// 2.加载 res id
		Glide.with(getApplicationContext()).load(R.drawable.face).error(R.drawable.qrcode).crossFade()
		. animate( android.R.anim.slide_in_left ) // or R.anim.zoom_in 加载动画
		. thumbnail( 0.1f ) // 缩略图  这个参数是一个 float 作为其大小的倍数。
				.placeholder(R.drawable.ic_launcher).into(ivHeads.get(1));
		
		// 3.加载bitmap 如果你只是想通过Glide加载一个Bitmap而不是把它显示到View中，比如想显示到通知栏里、作为上传头像等，Glide为你提供了灵活的接口SimpleTarget<Z>： 
//			 Glide.with(getApplicationContext()).load(urlArr[1]).asBitmap() // 
//					.centerCrop().into(new BitmapImageViewTarget(ivHeads.get(2)) {
//
//						@Override
//						protected void setResource(Bitmap resource) {
//							// TODO Auto-generated method stub
//							super.setResource(resource);
//						}
//					
//			    });
			 
			 Glide
			    .with(getApplicationContext())
			    .load(urlArr[1])
			    .asBitmap()
			    .centerCrop() // or whatever transformation you use on the `cover` view in XML
			    .into(new SimpleTarget<Bitmap>() {
					@Override 
					public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
			            final Target<?> that = this;
			            ivHeads.get(2).setImageBitmap(resource);
//			                    	ivHeads.get(2).setBackground(new BitmapDrawable(resource)); // use blurred image
			                        Glide.clear(that); // free resources of intermediate load
			        }
			    })
			;
			 
		// 4.加载byte[]
			 Glide
			    .with(getApplicationContext())
			    .load(urlArr[2])
			    .asBitmap()
			    .centerCrop() // or whatever transformation you use on the `cover` view in XML
			    .into(new SimpleTarget<Bitmap>() {
					@Override 
					public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
			            final Target<?> that = this;
//			            ivHeads.get(2).setBackground(new BitmapDrawable(resource)); // use blurred image
			                        
			           byte[] bytes= BitmapUtil.Bitmap2Bytes(resource);
			           Glide
					    .with(getApplicationContext())
					    .load(bytes)
					    .transform( new RotateTransformation( getApplicationContext(), 90f )) // 旋转图片90 度
					    .error(R.drawable.qrcode).placeholder(R.drawable.ic_launcher).into(ivHeads.get(3));
			           
			           Glide.clear(that); // free resources of intermediate load
			        }
			    })
			;
			
	}
	
	// 自定义转换效果
	public class RotateTransformation extends BitmapTransformation {

	    private float rotateRotationAngle = 0f;

	    public RotateTransformation(Context context, float rotateRotationAngle) {
	        super( context );

	        this.rotateRotationAngle = rotateRotationAngle;
	    }

	    @Override
	    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
	        Matrix matrix = new Matrix();

	        matrix.postRotate(rotateRotationAngle);

	        return Bitmap.createBitmap(toTransform, 0, 0, toTransform.getWidth(), toTransform.getHeight(), matrix, true);
	    }

	    @Override
	    public String getId() {
	        return "rotate" + rotateRotationAngle;
	    }
	}
}
