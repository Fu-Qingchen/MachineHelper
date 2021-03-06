package top.fuqingchen.machinedesign;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

/**
 * @author Fu_Qingchen
 */
public class MainActivity extends AppCompatActivity {
    public DesignFragment designFragment = new DesignFragment();
    public CalculationFragment calculationFragment = new CalculationFragment();
    public InfoFragment infoFragment = new InfoFragment();
    public Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.frame_main, calculationFragment).show(calculationFragment).commit();
            fragment = calculationFragment;
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                TextView textView = findViewById(R.id.main_top_textView);

                switch (item.getItemId()) {
                    case R.id.menu_design:
                        textView.setText(getString(R.string.main_Design));
                        if (fragment != designFragment) {
                            if (designFragment.isAdded()) {
                                getSupportFragmentManager().beginTransaction().show(designFragment).hide(fragment).commit();
                            } else {
                                getSupportFragmentManager().beginTransaction().add(R.id.frame_main, designFragment).show(designFragment).hide(fragment).commit();
                            }
                            fragment = designFragment;
                        }
                        return true;
                    case R.id.menu_calculation:
                        textView.setText(getString(R.string.main_Calculation));
                        if (fragment != calculationFragment) {
                            if (calculationFragment.isAdded()) {
                                getSupportFragmentManager().beginTransaction().show(calculationFragment).hide(fragment).commit();
                            } else {
                                getSupportFragmentManager().beginTransaction().add(R.id.frame_main, calculationFragment).show(calculationFragment).hide(fragment).commit();
                            }
                            fragment = calculationFragment;
                        }
                        return true;
                    case R.id.menu_info:
                        textView.setText(getString(R.string.main_Info));
                        if (fragment != infoFragment) {
                            if (infoFragment.isAdded()) {
                                getSupportFragmentManager().beginTransaction().show(infoFragment).hide(fragment).commit();
                            } else {
                                getSupportFragmentManager().beginTransaction().add(R.id.frame_main, infoFragment).show(infoFragment).hide(fragment).commit();
                            }
                            fragment = infoFragment;
                        }
                        return true;
                    default:
                        return false;
                }
            }
        });

    }

}
