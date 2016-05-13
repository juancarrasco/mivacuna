package com.example.root.mivacuna;

import android.annotation.TargetApi;
import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class CalendarioFragment extends Fragment implements OnTabChangeListener {

    private OnFragmentInteractionListener mListener;
    private static final String TAG = "FragmentTabs";
    public static final String TAB_WORDS = "words";
    public static final String TAB_NUMBERS = "numbers";


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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
          mLocalActivityManager = new LocalActivityManager(this.getActivity(), false);
mLocalActivityManager.dispatchCreate(savedInstanceState);
        mRoot = inflater.inflate(R.layout.fragment_calendario, container,false);

		mTabHost = (TabHost) mRoot.findViewById(android.R.id.tabhost);
         resources = getResources();
setupTabs();

         spinner = (Spinner) mRoot.findViewById(R.id.spinner);

        final ListView listview = (ListView) mRoot.findViewById(R.id.listView2);
    String[] values = new String[] { "Recien Nacido", "2 Meses", "4 Meses",
        "6 Meses", "8 Meses", "12 Meses", "15 Meses", "18 Meses",
        "4 Años", "5 Años" };

    final ArrayList<String> list = new ArrayList<String>();
    for (int i = 0; i < values.length; i++) {
      list.add(values[i]);
    }
    final ArrayAdapter adapter = new ArrayAdapter(getActivity(),
        android.R.layout.simple_list_item_1, resources.getStringArray(R.array.grupos_vacunas));
    listview.setAdapter(adapter);
    listview.setVerticalScrollBarEnabled(true);
    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

      @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
      @Override
      public void onItemClick(AdapterView<?> parent, final View view,
                              final int position, long id) {
        final String item = (String) parent.getItemAtPosition(position);
        view.animate().setDuration(2000).alpha(0)
            .withEndAction(new Runnable() {
              @Override
              public void run() {
                  list.remove(item);
                  mTabHost.setCurrentTab(1);
                  spinner.setSelection(position,true);
                  adapter.notifyDataSetChanged();
                view.setAlpha(1);
              }
            });
      }

    });










// Create an ArrayAdapter using the string array and a default spinner layout
ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(getActivity(),
        R.array.grupos_vacunas, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
spinner.setAdapter(adapter);


ArrayList<vacunas> vacunasArrayList = new ArrayList<vacunas>();



                final ArrayAdapterVacunas adapterVacunas = new ArrayAdapterVacunas(getActivity(),vacunasArrayList);
        adapterVacunas.add(new vacunas("Bacillus Calmette-Guerin (BCG)","La vacuna de BCG proporciona inmunidad o protección contra la tuberculosis. La vacuna puede ser administrada a las personas con alto riesgo de contraer tuberculosis. También se usa para tratar los tumores a la vesícula o el cáncer a la vejiga."));
        adapterVacunas.add(new vacunas("Hepatitis B","La hepatitis B es una enfermedad del hígado provocada por el virus de la hepatitis B (VHB)."));
        adapterVacunas.add(new vacunas("chicum","sueño y hambreee"));
        adapterVacunas.add(new vacunas("chicum","sueño y hambreee"));
        adapterVacunas.add(new vacunas("chicum","sueño y hambreee"));


        final ListView listviewVacunas = (ListView) mRoot.findViewById(R.id.listViewVacunas);

listviewVacunas.setAdapter(adapterVacunas);

listviewVacunas.setOnTouchListener(new View.OnTouchListener() {

    public boolean onTouch(View v, MotionEvent event) {
        return (event.getAction() == MotionEvent.ACTION_MOVE);
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
	private void setupTabs() {
        mTabHost.setup();


TabHost.TabSpec spec2=mTabHost.newTabSpec("mitab2");
        spec2.setContent(R.id.tab_2);
spec2.setIndicator("Consultar Calendario",resources.getDrawable(R.drawable.ic_calendar_plus));
	 // you must call this before adding your tabs!
        TabHost.TabSpec spec1=mTabHost.newTabSpec("mitab1");
        spec1.setContent(R.id.tab_1);
        spec1.setIndicator("Calendario",resources.getDrawable(R.drawable.ic_calendar));
        mTabHost.addTab(spec1);
        mTabHost.addTab(spec2);

	}

	private TabHost.TabSpec newTab(String tag, int labelId, int tabContentId) {
		Log.d(TAG, "buildTab(): tag=" + tag);


		TabSpec tabSpec = mTabHost.newTabSpec(tag);
		tabSpec.setContent(tabContentId);


		return tabSpec;
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

    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }
}
