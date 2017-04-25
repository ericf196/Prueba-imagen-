package com.rm.Sign;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rm.freedrawview.FreeDrawView;
import com.rm.freedrawview.PathDrawnListener;

public class FormActivity extends AppCompatActivity implements View.OnClickListener,
        FreeDrawView.DrawCreatorListener, PathDrawnListener ,View.OnKeyListener{

    private ImageView mImgScreen;
    private FreeDrawView mFreeDrawView;
    private Button mBtnClearAll,mBtnSend;
    private Menu mMenu;
    private View mSideView;
    private TextView mTextNameOrganization;
    private TextView mTextEmail;
    private TextView mTextInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);


        mImgScreen = (ImageView) findViewById(R.id.img_screen);
        mFreeDrawView = (FreeDrawView) findViewById(R.id.draw_signature);
        mSideView = findViewById(R.id.side_view);
        mBtnClearAll = (Button) findViewById(R.id.btn_clear_all);
        mBtnSend =(Button) findViewById(R.id.btn_send);

        mTextNameOrganization= (TextView) findViewById(R.id.edit_name_organization);
        mTextEmail= (TextView) findViewById(R.id.edit_email);
        mTextInformation= (TextView) findViewById(R.id.edit_information);

        mTextNameOrganization.setOnKeyListener(this);
        mTextEmail.setOnKeyListener(this);
        mTextInformation.setOnKeyListener(this);

        mFreeDrawView.setOnPathDrawnListener(this); // Escuchando 1
        mBtnClearAll.setOnClickListener(this);
        mBtnSend.setOnClickListener(this);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menu_form) {
            takeAndShowScreenshot();
            return true;
        }

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_clear_all:
                mFreeDrawView.undoAll();
                enabledBtnClearAll();
                enabledBtnSend();
                break;

            case R.id.btn_send:
                takeAndShowScreenshot();

                break;

            default:

                break;
        }

    }

    @Override
    public void onPathStart() {//Cuando se baja el touch
        Log.i("pintando","getUndoCount() "+ String.valueOf(enabledBtnClearAll()));
        enabledBtnSend();
    }

    @Override
    public void onNewPathDrawn() { //Cuando se levanta el touch
        //Log.i("pintando","getUndoCount() "+ String.valueOf(mFreeDrawView.getUndoCount()));
        //Log.i("pintando","getUndoCount() "+ String.valueOf(mFreeDrawView.getUndoCount()));
        enabledBtnSend();
        enabledBtnClearAll();

    }

    @Override
    public void onDrawCreated(Bitmap draw) {

        mSideView.setVisibility(View.GONE);
        mFreeDrawView.setVisibility(View.GONE);

        mMenu.findItem(R.id.menu_form).setVisible(false);

        mImgScreen.setVisibility(View.VISIBLE);

        mImgScreen.setImageBitmap(draw);

        new Save(getApplicationContext(), draw);

    }

    @Override
    public void onDrawCreationError() {
        Toast.makeText(this, "Error, cannot create bitmap", Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_form, menu);
        mMenu = menu;

        return true;
    }

    private void takeAndShowScreenshot() {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mFreeDrawView.getDrawScreenshot(this);
    }

    public void onBackPressed() {
        if (mImgScreen.getVisibility() == View.VISIBLE) {
            mMenu.findItem(R.id.menu_form).setVisible(true);
            mImgScreen.setImageBitmap(null);
            mImgScreen.setVisibility(View.GONE);
            mFreeDrawView.setVisibility(View.VISIBLE);
            mSideView.setVisibility(View.VISIBLE);

            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        } else {
            super.onBackPressed();
        }
    }

    public boolean enabledBtnClearAll(){
        if (mFreeDrawView.getUndoCount()!=0) {
            mBtnClearAll.setEnabled(true);
            return true;
        }else {
            mBtnClearAll.setEnabled(false);
            return false;
        }

    }

    public boolean enabledBtnSend(){
        if(!mTextNameOrganization.getText().toString().isEmpty() && !mTextEmail.getText().toString().isEmpty() && !mTextInformation.getText().toString().isEmpty() && enabledBtnClearAll()){
            mBtnSend.setEnabled(true);
            return true;
        }else {
            mBtnSend.setEnabled(false);
            return false;
        }


    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        //Log.i("pintando","onKey "+ String.valueOf(event));
        switch (v.getId()) {

            case R.id.edit_name_organization:
                enabledBtnSend();
                //Log.i("pintando","onKey edit_name_organization "+ String.valueOf(event.getAction()==KeyEvent.ACTION_UP));
                break;

            case R.id.edit_email:
                //Log.i("pintando","onKey edit_email "+ String.valueOf(event.getAction()==KeyEvent.ACTION_UP));
                enabledBtnSend();
                break;

            case R.id.edit_information:
                //Log.i("pintando","onKey edit_information "+ String.valueOf(event.getAction()==KeyEvent.ACTION_UP));
                enabledBtnSend();
                break;

            default:

                break;

        }
        return false;
    }
}
