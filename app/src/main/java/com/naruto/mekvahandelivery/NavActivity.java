package com.naruto.mekvahandelivery;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.naruto.mekvahandelivery.Adapter.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NavActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private final String TAG = this.getClass().getSimpleName();
//    private LoginSessionManager mSession;

    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();

    private int lastExpandedPosition = -1;
//    HashMap<String, String> mUserInfo;

//    List<MyVehicleTable> mMyVehicleTableList;

//    private CardView mMenuMyVehicleLayout;
//    private MyVehicleMenuAdapter mMenuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        mSession  = new LoginSessionManager(getApplicationContext());
//        mUserInfo = mSession.getUserDetailsFromSP();
//
//        if (!mSession.isLoggedIn()) {
//            mSession.checkLogin();
//            finish();
//            return;
//        }
//
//        if(mSession.getDefaultVehicleId() == -1){
//            Log.e(TAG,"Vehicle Default id is -1");
//            startActivity(new Intent(AppHomePage.this, HandsFreeAccess.class));
//            finish();
//            return;
//        }


        setContentView(R.layout.home_page);
        Log.e(TAG,"Login successfully");

//        mMenuMyVehicleLayout = findViewById(R.id.menu_my_vehicle_layout);
//        mMyVehicleTableList = new ArrayList<>();
//        //fetchSavedVehicle();

        setNavigationDrawer();
//        setBottomNavigationAndFab();
//        clickListener();

    }

//    private void clickListener() {
//
//        findViewById(R.id.search_text).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mMenuMyVehicleLayout.setVisibility(View.GONE);
//            }
//        });
//
//        findViewById(R.id.cart).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mMenuMyVehicleLayout.setVisibility(View.GONE);
//                startActivity(new Intent(AppHomePage.this, CartHomePage.class));
//            }
//        });
//
//        findViewById(R.id.select_vehicle).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e(TAG,"clicked");
//                if(mMenuMyVehicleLayout.getVisibility() == View.VISIBLE)
//                    mMenuMyVehicleLayout.setVisibility(View.GONE);
//                else
//                    mMenuMyVehicleLayout.setVisibility(View.VISIBLE);
//
//
//            }
//        });
//
//
//        findViewById(R.id.to_my_vehicle).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(AppHomePage.this, MyVehicleHomePage.class));
//                mMenuMyVehicleLayout.setVisibility(View.GONE);
//            }
//        });
//
//    }

//    private void setBottomNavigationAndFab() {
//
//        //To remove the animation in bottomNavigation
//        BottomNavigationView mBottomNavigationView = findViewById(R.id.botton_navigation);
//        BottomNavigationViewHelper.removeShiftMode(mBottomNavigationView);
//
//        mBottomNavigationView.setOnNavigationItemSelectedListener(
//                new BottomNavigationView.OnNavigationItemSelectedListener() {
//                    @Override
//                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                        int id = item.getItemId();
//                        switch (id){
//                            case R.id.nav_home:
//                                Log.e(TAG,"home is clicked");
//                                return true;
//                            case R.id.nav_bookings:
//                                // startActivity(new Intent(HomePage.this, ParkMeMap.class));
//                                return true;
//                            case R.id.nav_wallet:
//                                //startActivity(new Intent(HomePage.this, SOSHomePage.class));
//                                return true;
//                            case R.id.nav_profile:
//                                startActivity(new Intent(NavActivity.this,LoginActivity.class));
//                                return true;
//                        }
//                        return false;
//                    }});
//
//        ImageView fabScan = findViewById(R.id.fab_scan);
//        fabScan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // startActivity(new Intent(HomePage.this, ScanHomePage.class));
//            }
//        });
//
//    }

    private void setNavigationDrawer(){

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        expandableListView = findViewById(R.id.expandableListView);
        prepareMenuData();
        populateExpandableList();

        final DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(

                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.setDrawerIndicatorEnabled(false);
        Drawable icon = ResourcesCompat.getDrawable(getResources(), R.drawable.drawer_icon,NavActivity.this.getTheme());
        toggle.setHomeAsUpIndicator(icon);

        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mMenuMyVehicleLayout.setVisibility(View.GONE);
                if (drawer.isDrawerVisible(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });

        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Set Navigation Header
        View headerView      =  navigationView.getHeaderView(0);

        ImageView iv_profile =  headerView.findViewById(R.id.profile_pic);
//        TextView tv_name     =  headerView.findViewById(R.id.name);
//        TextView tv_mobile   =  headerView.findViewById(R.id.mobile);

        // need to set a profile pic -
        iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(AppHomePage.this,Profile.class));
                drawer.closeDrawer(GravityCompat.START);
            }
        });
//        tv_name.setText(mUserInfo.get(LoginSessionManager.NAME));
//        tv_mobile.setText(mUserInfo.get(LoginSessionManager.MOBILE));

    }

    private void prepareMenuData() {

        List<MenuModel> childModelsList = new ArrayList<>();

        MenuModel menuModel = new MenuModel(0,"Home",false,true,R.drawable.ic_home_black_24dp);
        headerList.add(menuModel);
        if (!menuModel.isHasChildren()) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel(0,"Profile",false,true,R.drawable.ic_account_circle_black_24dp);
        headerList.add(menuModel);
        if (!menuModel.isHasChildren()) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel(3,"Bookings", true, true, R.drawable.ic_bookings);
        headerList.add(menuModel);
        MenuModel childModel = new MenuModel(31,"Upcoming Bookings", false, false, 0);
        childModelsList.add(childModel);
        childModel = new MenuModel(32,"Ongoing Bookings", false, false, 0);
        childModelsList.add(childModel);
        childModel = new MenuModel(33,"History", false, false, 0);
        childModelsList.add(childModel);
        if (menuModel.isHasChildren()) {
            childList.put(menuModel, childModelsList);
        }

        menuModel = new MenuModel(4,"Transaction History",false,true,R.drawable.ic_mekcoins_wallet);
        headerList.add(menuModel);
        if (!menuModel.isHasChildren()) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel(4,"Notifications",false,true,R.drawable.ic_notification);
        headerList.add(menuModel);
        if (!menuModel.isHasChildren()) {
            childList.put(menuModel, null);
        }


        menuModel = new MenuModel(4,"About Us",false,true,R.drawable.ic_about_us);
        headerList.add(menuModel);
        if (!menuModel.isHasChildren()) {
            childList.put(menuModel, null);
        }


        menuModel = new MenuModel(6,"Support",false,true,R.drawable.ic_help);
        headerList.add(menuModel);
        if (!menuModel.isHasChildren()) {
            childList.put(menuModel, null);
        }

    }

    private void populateExpandableList() {

        expandableListAdapter = new ExpandableListAdapter(this, headerList, childList);

        ViewGroup footerView = (ViewGroup) getLayoutInflater().inflate(R.layout.home_page_expandable_view_footer, expandableListView, false);
        expandableListView.addFooterView(footerView);

        footerView.findViewById(R.id.footer_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mSession.logoutUser();
                finishAffinity();
            }
        });


        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                MenuModel menuModel = headerList.get(groupPosition);
                int id_int = (int) id;

                if (menuModel.isGroup()) {

                    if (!menuModel.isHasChildren()) {
                        switch (id_int){
                            case 0: //startActivity(new Intent(AppHomePage.this, ProfilePage.class));
                            break;
                            case 1: //startActivity(new Intent(AppHomePage.this, MyVehicleHomePage.class));
                            break;
                            case 2: //startActivity(new Intent(AppHomePage.this, MyAddressHomePage.class));
                            break;
                            case 3: //startActivity(new Intent(AppHomePage.this,MekCoinsWallet.class));break;
                                break;
                            case 4: break;
                            case 5: break;
                            case 6: break;
                            case 7: //startActivity(new Intent(AppHomePage.this, RefarralsHomePage.class));
                            break;
                            case 8: //startActivity(new Intent(AppHomePage.this, OffersHomePage.class));
                            break;
                            case 9: //startActivity(new Intent(AppHomePage.this, AboutUsPage.class));
                            break;
                        }
                        onBackPressed();
                    }
                }

                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
                                        int childPosition, long id) {

                if (childList.get(headerList.get(groupPosition)) != null) {

//                    MenuModel model = childList.get(headerList.get(groupPosition)).get(childPosition);

                    switch (groupPosition) {
                        case 3:
                            switch (childPosition) {
                                case 31:
                                    //startActivity( new Intent(AppHomePage.this,NewBookings.class));
                                    break;
                                case 32:
//                                    Intent i = new Intent(AppHomePage.this, BookingHomePage.class);
//                                    Bundle b = new Bundle();
//                                    b.putInt("viewPagerId",0);
//                                    i.putExtras(b);
//                                    startActivity(i);
                                    break;
                                case 33:
//                                    Intent i2 = new Intent(AppHomePage.this, BookingHomePage.class);
//                                    Bundle b2 = new Bundle();
//                                    b2.putInt("viewPagerId",1);
//                                    i2.putExtras(b2);
//                                    startActivity(i2);
                                    break;
                            }
                            break;
                    }

                    onBackPressed();

                }

                return false;

            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

                if (lastExpandedPosition != -1
                        && groupPosition != lastExpandedPosition) {
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;

            }
        });
    }

    @Override
    public void onBackPressed() {
//        mMenuMyVehicleLayout.setVisibility(View.GONE);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            finish();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    private void fetchSavedVehicle() {
//        new FetchVehicleFromRoom(MekVahanDatabase.getInstance(AppHomePage.this)).execute();
//    }


//    @Override
//    public void updatePage() {
//        loadFragment();
//    }

//    class FetchVehicleFromRoom extends AsyncTask<Void,Void,Void> {
//
//        private final MyVehicleDao myVehiclesDao;
//
//        public FetchVehicleFromRoom(MekVahanDatabase instance) {
//            myVehiclesDao = instance.getMyVehicleDao();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            if(mMyVehicleTableList !=null)
//                mMyVehicleTableList.clear();
//            mMyVehicleTableList = myVehiclesDao.getAllMyVehicles();
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//            startMenuVehicleAdapter();
//        }
//    }

//    private void startMenuVehicleAdapter() {
//
//        RecyclerView recyclerView = findViewById(R.id.recycler_view_menu_my_vehicle);
//        recyclerView.setLayoutManager(new LinearLayoutManager(AppHomePage.this));
//        mMenuAdapter = new MyVehicleMenuAdapter(AppHomePage.this,mMyVehicleTableList, AppHomePage.this);
//        recyclerView.setAdapter(mMenuAdapter);
//
//        loadFragment();
//
//    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"onResume");
//        fetchSavedVehicle();
//        loadFragment();
    }

//    public void loadFragment(){
//        replaceFragment(new FragmentMainContent());
//    }
//
//    public void replaceFragment(Fragment fragment) {
//
//        Log.e(TAG, "replaceFragment");
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(R.id.main_frame_layout, fragment);
//        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        ft.commit();
//    }

}