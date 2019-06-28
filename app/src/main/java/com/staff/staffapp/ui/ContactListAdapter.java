package com.staff.staffapp.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.github.abdularis.civ.AvatarImageView;
import com.staff.staffapp.R;


public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ViewHolder> {
    class Contacts {
        String name;
        String status;
        int avatar;

        Contacts(String name, String status, int avatar) {
            this.name = name;
            this.status = status;
            this.avatar = avatar;
        }
    }


    Contacts contacts[] = new Contacts[] {
            new Contacts("Lorna", "online", R.drawable.avatar_1),
            new Contacts("Roba", "available",R.drawable.avatar_2),
            new Contacts("Wanyama", "available",R.drawable.avatar_3)

    };

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(contacts[position]);
    }

    @Override
    public int getItemCount() {
        return contacts.length;
    }
    class ViewHolder extends RecyclerView.ViewHolder {

        AvatarImageView avatar;
        TextView name;
        TextView status;

        public ViewHolder(View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            name = itemView.findViewById(R.id.text_name);
            status = itemView.findViewById(R.id.text_stat);
        }

        void bind(Contacts p) {
            if (p.avatar == 0) {
                avatar.setState(AvatarImageView.SHOW_INITIAL);
                avatar.setText(p.name);
            } else {
                avatar.setState(AvatarImageView.SHOW_IMAGE);
                avatar.setImageResource(p.avatar);
            }

            name.setText(p.name);
            status.setText(p.status);
        }
    }


}
