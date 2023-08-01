//package com.example.expensetracker;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import androidx.recyclerview.widget.RecyclerView;
//import java.util.ArrayList;
//
//public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
//    private Context context;
//    private ArrayList<DataModel> dataList;
//    public DataAdapter(Context context, int list_item, ArrayList<DataModel> dataList) {
//        this.context = context;
//        this.dataList = dataList;
//    }
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,
//                false);
//        return new ViewHolder(view);
//    }
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        DataModel data = dataList.get(position);
//        holder.idTextView.setText(String.valueOf(data.getId()));
//        holder.nameTextView.setText(data.getName());
//        holder.addressTextView.setText(data.getAddress());
//    }
//    @Override
//    public int getItemCount() {
//        return dataList.size();
//    }
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        TextView idTextView;
//        TextView nameTextView;
//        TextView addressTextView;
//        public ViewHolder(View itemView) {
//            super(itemView);
//            idTextView = itemView.findViewById(R.id.idTextView);
//            nameTextView = itemView.findViewById(R.id.nameTextView);
//            addressTextView = itemView.findViewById(R.id.addressTextView);
//
//        }
//    }
//}
