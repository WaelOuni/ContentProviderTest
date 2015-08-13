package tn.calculator.squeezer.contentprovidertest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

import tn.calculator.squeezer.contentprovidertest.adapter.MyAdapter;
import tn.calculator.squeezer.contentprovidertest.model.MyObject;

/**
 * A placeholder fragment containing a simple view.
 */
public class RetrieveFragment extends Fragment {

    private RecyclerView recyclerView;

    private List<MyObject> cities = new ArrayList<>();
    public RetrieveFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        ajouterVilles();
        View rootView = inflater.inflate(R.layout.fragment_retrieve, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        //définit l'agencement des cellules, ici de façon verticale, comme une ListView
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //pour adapter en grille comme une RecyclerView, avec 2 cellules par ligne
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        //puis créer un MyAdapter, lui fournir notre liste de villes.
        //cet adapter servira à remplir notre recyclerview
        recyclerView.setAdapter(new MyAdapter(cities));
        LineChart mLineChart = (LineChart) rootView.findViewById(R.id.chart);
        Entry c1e1 = new Entry(100.000f, 0); // 0 == quarter 1
        valsComp1.add(c1e1);
        Entry c1e2 = new Entry(50.000f, 1); // 1 == quarter 2 ...
        valsComp1.add(c1e2);
        // and so on ...

        Entry c2e1 = new Entry(120.000f, 0); // 0 == quarter 1
        valsComp2.add(c2e1);
        Entry c2e2 = new Entry(110.000f, 1); // 1 == quarter 2 ...
        valsComp2.add(c2e2);



        LineDataSet setComp1 = new LineDataSet(valsComp1, "Company 1");
        setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
        LineDataSet setComp2 = new LineDataSet(valsComp2, "Company 2");
        setComp2.setAxisDependency(YAxis.AxisDependency.LEFT);
        ArrayList<LineDataSet> dataSets = new ArrayList<LineDataSet>();
        dataSets.add(setComp1);
        dataSets.add(setComp2);

        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("1.Q"); xVals.add("2.Q"); xVals.add("3.Q"); xVals.add("4.Q");

        LineData data = new LineData(xVals, dataSets);
        mLineChart.setData(data);
        mLineChart.invalidate(); // refresh
        mLineChart.animateX(3000); // animate horizontal 3000 milliseconds
// or:
        mLineChart.animateY(3000); // animate vertical 3000 milliseconds
// or:
        mLineChart.animateXY(3000, 3000); // animate horizontal and vertical 3000 milliseconds
        return rootView;
    }

    private void ajouterVilles() {

        cities.add(new MyObject("France","http://t1.gstatic.com/images?q=tbn:ANd9GcSOhQlyJgJwLy30mBD_5uQrW4yIVECfo8HMkrEPh9_4nO1l8VWfeg"));
        cities.add(new MyObject("Angleterre", "http://www.wallfizz.com/nature/montagne/687-paysage---montagne-WallFizz.jpg"));
        cities.add(new MyObject("Allemagne", "http://www.gogoall.net/fonds/nature/p/paysage/paysage_32.jpg"));
        cities.add(new MyObject("Espagne", "http://img0.mxstatic.com/wallpapers/aead4c1e1d64654267105fb5325fa3d9_large.jpeg"));

    }

    ArrayList<Entry> valsComp1 = new ArrayList<Entry>();
    ArrayList<Entry> valsComp2 = new ArrayList<Entry>();

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

}
