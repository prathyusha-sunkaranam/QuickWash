package in.vinkrish.quickwash;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.MenuItem;

import butterknife.ButterKnife;
import in.vinkrish.quickwash.fragment.AboutUs;
import in.vinkrish.quickwash.fragment.QuickWashService;
import in.vinkrish.quickwash.fragment.ViewOrders;

public class HomeActivity extends AppCompatActivity {
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                menuItem.setChecked(true);
                drawerLayout.closeDrawers();

                switch (menuItem.getItemId()) {

                    case R.id.dashboard_item:
                        ReplaceFragment.replace(new QuickWashService(), getSupportFragmentManager());
                        return true;

                    case R.id.order_item:
                        ReplaceFragment.replace(new ViewOrders(), getSupportFragmentManager());
                        return true;

                    case R.id.contact_item:
                        ReplaceFragment.replace(new AboutUs(), getSupportFragmentManager());
                        return true;

                    default:
                        return true;

                }
            }

        });

        drawerLayout = findViewById(R.id.drawer);
        android.support.v7.app.ActionBarDrawerToggle actionBarDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();

        if (savedInstanceState == null) {
            selectDefaultFragment();
        }

    }

    private void selectDefaultFragment() {
        ReplaceFragment.replace(new QuickWashService(), getSupportFragmentManager());
    }

}
