package com.example.afinal;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class StartFragment extends Fragment {

    Dialog dialog;
    TextView txtok, txtnon, txtDateDebut, txtDateFin;

    Button btn_R,btn_DD,btn_DF;
    int dE,mE,yE ,dS,mS,yS;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<SlideModel> ImageList = new ArrayList<>();

        ImageList.add(new SlideModel(R.drawable.imagel, "Tremblay Location", ScaleTypes.CENTER_CROP));
        ImageList.add(new SlideModel(R.drawable.imagem, "Tremblay Location", ScaleTypes.CENTER_CROP));
        ImageList.add(new SlideModel(R.drawable.imagen, "Tremblay Location",ScaleTypes.CENTER_CROP));
        ImageList.add(new SlideModel(R.drawable.imageo, "Tremblay Location", ScaleTypes.CENTER_CROP));
        ImageList.add(new SlideModel(R.drawable.imagep, "Tremblay Location", ScaleTypes.CENTER_CROP));
        ImageList.add(new SlideModel(R.drawable.imageq, "Tremblay Location", ScaleTypes.CENTER_CROP));

        View view = inflater.inflate(R.layout.fragment_start, container, false);
        ImageSlider imageSlider = view.findViewById(R.id.imageSlider);
        imageSlider.setImageList(ImageList);

        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.custom_dialog);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.custom_dialog_bg);
        dialog.setCancelable(false);

        txtok = dialog.findViewById(R.id.ok);
        txtnon = dialog.findViewById(R.id.non);

        btn_R = view.findViewById(R.id.btnReserver);
        btn_DD = view.findViewById(R.id.btnDateDebut);
        btn_DF = view.findViewById(R.id.btnDateFin);
        txtDateDebut = view.findViewById(R.id.affichedateD);
        txtDateFin = view.findViewById(R.id.affichedateF);

        btn_DD.setOnClickListener(v -> {
            Calendar cal=Calendar.getInstance();
            int jour=cal.get(Calendar.DAY_OF_MONTH);
            int mois=cal.get(Calendar.MONTH);
            int annee=cal.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog=new DatePickerDialog(getActivity(), (view1, year, month, dayOfMonth) -> {
                yE=year;
                mE=month;
                dE=dayOfMonth;
                txtDateDebut.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            },annee,mois,jour);
            datePickerDialog.create();
            datePickerDialog.show();
        });

        btn_DF.setOnClickListener(v -> {
            Calendar cal=Calendar.getInstance();
            int jour=cal.get(Calendar.DAY_OF_MONTH);
            int mois=cal.get(Calendar.MONTH);
            int annee=cal.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog=new DatePickerDialog(getActivity(), (view1, year, month, dayOfMonth) -> {
                yS=year;
                mS=month;
                dS=dayOfMonth;
                txtDateFin.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            },annee,mois,jour);
            datePickerDialog.create();
            datePickerDialog.show();
        });


        btn_R.setOnClickListener(view1 -> dialog.show());

        txtnon.setOnClickListener(view1 -> dialog.dismiss());

        return view;
    }
}