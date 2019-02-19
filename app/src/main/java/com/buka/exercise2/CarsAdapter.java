package com.buka.exercise2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.buka.exercise2.models.Car;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarViewHolder>{

    private ArrayList<Car> cars = new ArrayList<>();
    private  OnItemClickedListener listener;

    /*public CarsAdapter(OnItemClickedListener listener) {
        this.listener = listener;
    }*/

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View carView = layoutInflater.inflate(R.layout.item_car, parent, false);
        CarViewHolder viewHolder = new CarViewHolder(carView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = cars.get(position);
        holder.carTextView.setText(car.getManufacturer() + ": " + car.getModel() + " " + car.getColor() + " - " + car.getYear());
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public void setCars(ArrayList<Car> cars){
        if(cars != null){
            this.cars = cars;
            notifyDataSetChanged();
        }
    }

    interface OnItemClickedListener{
        void onItemClicked(Car car);
    }

    class CarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView carTextView;

        public CarViewHolder(View carView) {
            super(carView);
            carTextView = carView.findViewById(R.id.textview_car);

            carView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedItemPosition = getAdapterPosition();
            Car clickedCar = cars.get(clickedItemPosition);

            listener.onItemClicked(clickedCar);
        }
    }
}
