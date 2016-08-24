package win.waylib.anmould.zxing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import win.waylib.anmould.R;

//import com.tronsis.dogchain.SysApplication;
//import com.tronsis.dogchain.biz.impl.PetBizImp;
//import com.tronsis.dogchain.dto.PetDTO;
//import com.tronsis.dogchain.http.HttpConfig;
//import com.tronsis.dogchain.utils.FileUtil;
//import com.tronsis.dogchain.utils.StringUtil;
//import com.tronsis.dogchain.utils.ToastUtil;
//import com.tronsis.dogchain.widget.CircleImageView;


public class ShowQrcodeActivity extends Activity {
//    private PetBizImp petBizImp = new PetBizImp();
//    private PetDTO petDTO;
//
//    private CircleImageView dogAvatarCiv;

    private TextView dogAliasTv;

    private ImageView qrcodeIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_qrcode);
        initData();
    }


    protected void initData() {
//        dogAvatarCiv = (CircleImageView) findViewById(R.id.icv_dog_avatar);
//        dogAliasTv = (TextView) findViewById(R.id.tv_dog_alias);
//        qrcodeIv = (ImageView) findViewById(R.id.iv_qrcode);


        Intent intent = getIntent();
        final String dogAvatarUrl = intent.getStringExtra("dogAvatarUrl");
        String dogAlias = intent.getStringExtra("dogAlias");
        final String dogQR = intent.getStringExtra("dogQR");

        long petId = intent.getLongExtra("dogID", 0);
//        if (!StringUtil.isBlank(dogAvatarUrl) && dogAvatarUrl != null) {
//            SysApplication.imageLoader.displayImage(dogAvatarUrl, dogAvatarCiv);
//        } else {
//            dogAvatarCiv.setImageResource(R.drawable.dog_default_avatar);
//        }
//
//        if (!StringUtil.isBlank(dogAlias)) {
//            dogAliasTv.setText(dogAlias);
//        }

//        final String filePath = FileUtil.getMyFileDir(this) + "/" + "1.jpg";
//        File qrFile = new File(filePath);
//        if (qrFile.exists()) {
//            qrcodeIv.setImageBitmap(BitmapFactory.decodeFile(filePath));
//            return;
//            qrFile.delete();
//        }
//        if((HttpConfig.QRCODE_URL_PREFIX + dogQR).equals("http://120.24.73.180/dogchain?devid=123456789111111")){
//            ToastUtil.showMessage(ShowQrcodeActivity.this,"equal");
//        }
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Bitmap faceBmp = null;
//                if (dogAvatarUrl != null) {
//                    faceBmp = SysApplication.imageLoader.loadImageSync(dogAvatarUrl);
//                } else {
//                    faceBmp = BitmapFactory.decodeResource(getResources(), R.drawable.dog_default_avatar);
//                }
//                boolean success = QRCodeUtil.createQRImage(HttpConfig.QRCODE_URL_PREFIX + dogQR, 400, 400, faceBmp,
//                        filePath);
//                if (success) {
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            qrcodeIv.setImageBitmap(BitmapFactory.decodeFile(filePath));
//                        }
//                    });
//                }
//            }
//        }).start();
    }
}
