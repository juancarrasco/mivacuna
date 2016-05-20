package com.example.root.mivacuna;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.content.res.Resources;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.util.Log;
import android.widget.TextView;

import com.example.root.mivacuna.librerias.Calendario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CalendarioFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class CalendarioFragment extends Fragment implements OnTabChangeListener, android.support.v7.app.ActionBar.TabListener, ViewPager.OnPageChangeListener  {

    private OnFragmentInteractionListener mListener;
    private static final String TAG = "FragmentTabs";
    public static final String TAB_WORDS = "words";
    public static final String TAB_NUMBERS = "numbers";
    private ViewPager mViewPager;

    private View mRoot;
    private TabHost mTabHost;
    private int mCurrentTab;
    private LocalActivityManager  mLocalActivityManager;
    Resources resources;
    Spinner spinner;
    public CalendarioFragment() {
        // Required empty public constructor
    }

    @Override
    public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int arg0) {
            switch (arg0) {
                case 0:
                    return new CalendarioFragment();
                case 1:
                    return new CalendarioFragment();
                case 2:
                    return new CalendarioFragment();
                default:
                    return null;
            }
        }
        public int getCount() {
            return 3;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_calendario, container,false);

         resources = getResources();

        final ListView listview = (ListView) mRoot.findViewById(R.id.listView);



    final ArrayAdapter adapter = new ArrayAdapter(getActivity(),
        android.R.layout.simple_list_item_1, resources.getStringArray(R.array.grupos_vacunas));
    listview.setAdapter(adapter);
    listview.setVerticalScrollBarEnabled(true);
    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

      @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
      @Override
      public void onItemClick(AdapterView<?> parent, final View view,
                              final int position, long id) {

                  ConsultarCalendarioFragment.setSpinner(position);
                  ConsultarCalendarioFragment.setList(position);
                    MainActivity.cambiarTabs(1);



      }


    });



        return mRoot;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onTabChanged(String tabId) {

    }




    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
