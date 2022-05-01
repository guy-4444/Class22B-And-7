package com.guy.class22b_and_7;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class LiqueurAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public interface Liqueurlistener {
        void clicked(Liqueur liqueur, int position);
        void plus(Liqueur liqueur, int position);
        void minus(Liqueur liqueur, int position);
    }

    private Activity activity;
    private ArrayList<Liqueur> liqueurs = new ArrayList<>();
    private Liqueurlistener liqueurlistener;

    public LiqueurAdapter(Activity activity, ArrayList<Liqueur> liqueurs){
        this.activity = activity;
        this.liqueurs = liqueurs;
    }

    public void setLiqueurlistener(Liqueurlistener liqueurlistener) {
        this.liqueurlistener = liqueurlistener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_liqueur, parent, false);
        LiqueurHolder liqueurHolder = new LiqueurHolder(view);
        return liqueurHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        final LiqueurHolder holder = (LiqueurHolder) viewHolder;
        Liqueur liqueur = getItem(position);

        holder.liqueur_LBL_title.setText(liqueur.getName());
        holder.liqueur_LBL_description.setText(liqueur.getMl() + "ml | " + liqueur.getAlc() + "%");
        holder.liqueur_LBL_price.setText("$ " + liqueur.getPrice());
        holder.liqueur_LBL_amount.setText("" + liqueur.getAmount());


        int resourceId = activity.getResources().getIdentifier(liqueur.getImage(), "drawable", activity.getPackageName());
        holder.liqueur_IMG_image.setImageResource(resourceId);
    }

    @Override
    public int getItemCount() {
        return liqueurs.size();
    }

    public Liqueur getItem(int position) {
        return liqueurs.get(position);
    }



    class LiqueurHolder extends RecyclerView.ViewHolder {

        private AppCompatImageView liqueur_IMG_image;
        private MaterialTextView liqueur_LBL_title;
        private MaterialTextView liqueur_LBL_description;
        private MaterialTextView liqueur_LBL_price;
        private MaterialTextView liqueur_LBL_amount;
        private MaterialButton liqueur_BTN_plus;
        private MaterialButton liqueur_BTN_minus;


        public LiqueurHolder(View itemView) {
            super(itemView);
            liqueur_IMG_image = itemView.findViewById(R.id.liqueur_IMG_image);
            liqueur_LBL_title = itemView.findViewById(R.id.liqueur_LBL_title);
            liqueur_LBL_description = itemView.findViewById(R.id.liqueur_LBL_description);
            liqueur_LBL_price = itemView.findViewById(R.id.liqueur_LBL_price);
            liqueur_LBL_amount = itemView.findViewById(R.id.liqueur_LBL_amount);
            liqueur_BTN_plus = itemView.findViewById(R.id.liqueur_BTN_plus);
            liqueur_BTN_minus = itemView.findViewById(R.id.liqueur_BTN_minus);

            liqueur_BTN_minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (liqueurlistener != null) {
                        liqueurlistener.minus(getItem(getAdapterPosition()), getAdapterPosition());
                    }
                }
            });

            liqueur_BTN_plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (liqueurlistener != null) {
                        liqueurlistener.plus(getItem(getAdapterPosition()), getAdapterPosition());
                    }
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (liqueurlistener != null) {
                        liqueurlistener.clicked(getItem(getAdapterPosition()), getAdapterPosition());
                    }
                }
            });
        }

    }
}