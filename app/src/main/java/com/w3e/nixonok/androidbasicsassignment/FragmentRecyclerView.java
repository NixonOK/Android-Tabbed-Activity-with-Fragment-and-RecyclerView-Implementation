package com.w3e.nixonok.androidbasicsassignment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentRecyclerView.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentRecyclerView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRecyclerView extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OnFragmentInteractionListener mListener;

    public FragmentRecyclerView() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRecyclerView.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRecyclerView newInstance() {
        FragmentRecyclerView fragment = new FragmentRecyclerView();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment_recycler_view, container, false);

        RecyclerView recyclerView;


        // ImageList
        int[] images = {R.mipmap.ic_launcher};



        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ArrayList<Section> sectionArrayList = new ArrayList<>();
        for (int i = 0; i <2 ; i++) {

            String label;
            if (i == 0) label = "Student";
            else if(i == 1 ) label = "Teacher";
            else label = "Unknown";
            // Item List
            ArrayList<Item> listItem = new ArrayList();

            for (int j = 0; j < 5; j++) {

                Item item = new Item();
                item.setImage(images[0]);
                item.setTitle("Title " + (j + 1));
                item.setDescription("Description " + label + " " + (j + 1));

                listItem.add(item);
            }
            // adding to arraylist
            if (i == 0) sectionArrayList.add(new Section(label, listItem));
            else if (i == 1) sectionArrayList.add(new Section(label, listItem));
            else sectionArrayList.add(new Section(label, listItem));

            // Custom Recycler View Adaptor
            RecyclerViewSectionAdaptor adapter = new RecyclerViewSectionAdaptor(sectionArrayList, getActivity());
            recyclerView.setAdapter(adapter);

        }
//
//
//// Item List
//        List<Item> listItem = new ArrayList();
//
//        for (int i = 0; i < 5; i++) {
//
//            Item item = new Item();
//            item.setImage(images[0]);
//            item.setTitle("Title " + (i + 1));
//            item.setDescription("Description " + (i + 1));
//            item.setType(Item.TEACHER_TYPE);
//
//            listItem.add(item);
//        }
//        for (int i = 0; i < 5; i++) {
//
//            Item item = new Item();
//            item.setImage(images[0]);
//            item.setTitle("Title " + (i + 1));
//            item.setDescription("Description " + (i + 1));
//            item.setType(Item.STUDENT_TYPE);
//
//            listItem.add(item);
//        }




        return rootView;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
