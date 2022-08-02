package kr.hs.emirim.kjminn.mirim_project_0802_gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] posterId = {R.drawable.poster01,R.drawable.poster02,R.drawable.poster03,R.drawable.poster04,R.drawable.poster05,
                        R.drawable.poster06,R.drawable.poster07,R.drawable.poster08,R.drawable.poster09,R.drawable.poster10
                        };
    String[] posterTitle = {"범죄도시2", "쥬라기 공원(도미니언)", "브로커", "닥터스트레인지", "카시오페아", "로스트시티", "스파이더맨(노웨이홈)", "DUNE", "앵커", "마녀2"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gallery gallery = findViewById(R.id.gallery);
        GalleryAdapter adapter = new GalleryAdapter(this);
        gallery.setAdapter(adapter);
    }

    public class GalleryAdapter extends BaseAdapter{
        Context context;
        public GalleryAdapter(Context context){
            this.context = context;
        }

        @Override
        public int getCount() {
            return posterId.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imgv = new ImageView(context);
            Gallery.LayoutParams params = new Gallery.LayoutParams(200, 300);
            imgv.setLayoutParams(params);
            imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgv.setImageResource(posterId[i]);
            final int pos = i;
            imgv.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ImageView largeImgv = findViewById(R.id.imgv);
                    largeImgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    largeImgv.setImageResource(posterId[pos]);
                    Toast t = new Toast(context);
                    View toastView = View.inflate(context, R.layout.toast, null);
                    TextView textTitle = toastView.findViewById(R.id.text_title);
                    textTitle.setText(posterTitle[pos]);
                    t.setView(toastView);
                    t.setDuration(Toast.LENGTH_SHORT);
                    t.show();
                    return false;
                }
            });

            return imgv;
        }
    }
}