package id.ac.unej.ilkom.simulatour.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.simulatour.Activities.AboutActivity;
import id.ac.unej.ilkom.simulatour.Activities.MakananActivity;
import id.ac.unej.ilkom.simulatour.Activities.PenginapanActivity;
import id.ac.unej.ilkom.simulatour.Activities.SewaActivity;
import id.ac.unej.ilkom.simulatour.Activities.TransportasiActivity;
import id.ac.unej.ilkom.simulatour.Activities.WisataActivity;
import id.ac.unej.ilkom.simulatour.R;
import id.ac.unej.ilkom.simulatour.SliderIndicator;
import id.ac.unej.ilkom.simulatour.Adapters.SliderPagerAdapter;
import id.ac.unej.ilkom.simulatour.SliderView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    //CardView wisata, penginapan, transport, makanan, sewa,about;

    @BindView(R.id.wisata)
    CardView wisata;

    @BindView(R.id.penginapan)
    CardView penginapan;

    @BindView(R.id.transportasi)
    CardView transportasi;

    @BindView(R.id.makanan)
    CardView makanan;

    @BindView(R.id.sewa)
    CardView sewa;

    @BindView(R.id.about)
    CardView about;

    @BindView(R.id.pagesContainer)
    LinearLayout mLinearLayout;

    @BindView(R.id.sliderView)
    SliderView sliderView;

    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;
   /* private LinearLayout mLinearLayout;
    private SliderView sliderView;*/

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);
       /* sliderView = (SliderView) view.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.pagesContainer);
        wisata = (CardView) view.findViewById(R.id.wisata);
        penginapan = (CardView) view.findViewById(R.id.penginapan);
        transport = (CardView) view.findViewById(R.id.transportasi);
        makanan = (CardView) view.findViewById(R.id.makanan);
        sewa = (CardView) view.findViewById(R.id.sewa);
        about = (CardView) view.findViewById(R.id.about);*/
        setupSlider();
        wisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), WisataActivity.class);
                startActivity(i);
            }
        });
        penginapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), PenginapanActivity.class);
                startActivity(i);
            }
        });
        transportasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), TransportasiActivity.class);
                startActivity(i);
            }
        });
        makanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), MakananActivity.class);
                startActivity(i);
            }
        });
        sewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), SewaActivity.class);
                startActivity(i);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),AboutActivity.class);
                startActivity(i);
            }
        });
        return view;
    }
    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(SliderFragment.newInstance("http://helloworlds.me/simulatour/images.png"));
        fragments.add(SliderFragment.newInstance("http://helloworlds.me/simulatour/images2.jpg"));
        fragments.add(SliderFragment.newInstance("http://helloworlds.me/simulatour/images3.jpg"));
        fragments.add(SliderFragment.newInstance("http://helloworlds.me/simulatour/images4.jpg"));

        mAdapter = new SliderPagerAdapter(getChildFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicator_slider);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }

}
