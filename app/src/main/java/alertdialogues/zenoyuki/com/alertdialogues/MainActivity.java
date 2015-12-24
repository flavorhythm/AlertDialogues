package alertdialogues.zenoyuki.com.alertdialogues;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button showBtn;
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showBtn = (Button)findViewById(R.id.show_btn_ID);

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpDialog();

                AlertDialog alertD = dialog.create();
                alertD.show();
            }
        });
    }

    public void setUpDialog() {
        dialog = new AlertDialog.Builder(MainActivity.this);

        dialog.setTitle(getResources().getString(R.string.dialog_title));
        dialog.setMessage(getResources().getString(R.string.dialog_content));
        dialog.setCancelable(false);
        dialog.setIcon(android.R.drawable.star_on);

        dialog.setPositiveButton(getResources().getString(R.string.posi_btn), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.finish();
            }
        });

        dialog.setNegativeButton(getResources().getString(R.string.nega_btn), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
    }
}
