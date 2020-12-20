package com.example.weddinghall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.weddinghall.helper.HelperMethod;
import com.example.weddinghall.ui.CamActivity;
import com.example.weddinghall.ui.HomeFragment;
import com.example.weddinghall.ui.InformationFragment;
import com.example.weddinghall.ui.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       bottomNavigationView =findViewById(R.id.bottom_Navigation_Home);
       bottomNavigationView.setOnNavigationItemSelectedListener(nav_Bottom);
       bottomNavigationView.setSelectedItemId(R.id.home_Fragment);
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_container,HomeFragment).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener nav_Bottom= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment SelectFragment = null;
            switch (item.getItemId()){
                case R.id.home_Fragment:
                    SelectFragment = new HomeFragment();
                    break;
                case R.id.informationFragment:
                    SelectFragment = new InformationFragment();
                    break;
                case R.id.settingFragment:
                    SelectFragment = new SettingFragment();

//                    Intent i = new Intent(MainActivity.this, CamActivity.class);
//                    startActivity(i);

                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,SelectFragment).commit();
            return true;
        }
    };
//    public void backPressClick(){
//        //this will pop the last added fragment which is fragmentA in your case
//        HomeFragment homeFragment = new HomeFragment();
//        HelperMethod.replace(homeFragment,getSupportFragmentManager(),R.id.home_Fragment,null,null);
//    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.search_item:
                // do your code
                return true;
            case R.id.upload_item:
                // do your code
                return true;
            case R.id.copy_item:
                // do your code
                return true;
            case R.id.print_item:
                // do your code
                return true;
            case R.id.share_item:
                // do your code
                return true;
            case R.id.bookmark_item:
                // do your code
                return true;
//            case  R.id.InformationFragment:
//                InformationFragment informationFragment = new InformationFragment();
//                HelperMethod.replace(informationFragment,getSupportFragmentManager(),R.id.InformationFragment,null,null);
//                return true;
                default:
                return super.onOptionsItemSelected(item);
        }
    }


//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        int i = item.getItemId();
//        switch (i){
//            case  R.id.informationFragment:
//                InformationFragment informationFragment = new InformationFragment();
//                HelperMethod.replace(informationFragment,getSupportFragmentManager(),R.id.informationFragment,null,null);
//                return true;
//            case  R.id.home_Fragment:
//
//
//                return true;
//            case  R.id.settingFragment:
//
//
//                return true;
//        }
//        return true;
//    }

//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//
//    }
}











//    @OnClick({R.id.User_Login_ForgetPassword, R.id.User_Create_Register})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.User_Login_ForgetPassword:
//                User_Forget_Password_Fragment user_forget_password_fragment = new User_Forget_Password_Fragment();
//                HelperMethod.replace(user_forget_password_fragment, getActivity().getSupportFragmentManager(), R.id.Frame_login_client, null, null);
//
//                break;
//            case R.id.User_Create_Register:
//                RegisterClientFragment registerClientFragment = new RegisterClientFragment();
//                HelperMethod.replace(registerClientFragment, getActivity().getSupportFragmentManager(), R.id.Frame_login_client, null, null);
//                break;
//        }
