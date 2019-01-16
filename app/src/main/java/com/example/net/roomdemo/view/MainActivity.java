package com.example.net.roomdemo.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.net.roomdemo.R;
import com.example.net.roomdemo.entities.Contacts;
import com.example.net.roomdemo.entities.JobInfo;
import com.example.net.roomdemo.room.database.AppDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.et_firstname)
    TextInputEditText etFirstname;
    @BindView(R.id.et_lastname)
    TextInputEditText etLastname;
    @BindView(R.id.et_content)
    TextInputEditText etContent;
    @BindView(R.id.but_save)
    Button butSave;
    @BindView(R.id.btn_getList)
    Button btnGetList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.but_save, R.id.btn_getList})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_save:
                SaveTask st = new SaveTask();
                st.execute();
                break;
            case R.id.btn_getList:
                Intent intent=new Intent(this,ListContant.class);
                startActivity(intent);
                break;
        }
    }


    class SaveTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            //creating a task
            Contacts task = new Contacts();
            task.setFirstName(etFirstname.getText().toString());
            task.setLastName(etLastname.getText().toString());
            task.setPhoneNumber(etContent.getText().toString());
            JobInfo jobInfo=new JobInfo();
            jobInfo.setCompanyName("Npglobal");
            jobInfo.setJobAddress("NOida");
            //adding to database
            AppDatabase.getAppDatabase(getApplicationContext()).getContactDAO()
                    .insert(task);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
          //  startActivity(new Intent(getApplicationContext(), MainActivity.class));
            Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
        }
    }

}


