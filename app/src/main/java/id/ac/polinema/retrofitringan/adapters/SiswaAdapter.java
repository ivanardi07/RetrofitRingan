package id.ac.polinema.retrofitringan.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.polinema.retrofitringan.Post;
import id.ac.polinema.retrofitringan.R;

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.ViewHolder> {
    private List<Post> items;

    public SiswaAdapter(List<Post> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public SiswaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.item_siswa, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SiswaAdapter.ViewHolder holder, int position) {
        Post item = items.get(position);

        holder.textNIM.setText(item.getNim());
        holder.textNama.setText(item.getNama());
        holder.textAlamat.setText(item.getAlamat());
        holder.textJenisKelamin.setText(item.getJenis_kelamin());
        holder.textNoTelp.setText(item.getNo_telp());
    }

    @Override
    public int getItemCount() {
        return (items != null) ? items.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textNIM, textNama, textAlamat, textJenisKelamin, textNoTelp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textNIM = (TextView) itemView.findViewById(R.id.id_siswa);
            textNama = (TextView) itemView.findViewById(R.id.nama);
            textAlamat = (TextView) itemView.findViewById(R.id.alamat);
            textJenisKelamin = (TextView) itemView.findViewById(R.id.jk);
            textNoTelp = (TextView) itemView.findViewById(R.id.no_telp);
        }
    }
}
