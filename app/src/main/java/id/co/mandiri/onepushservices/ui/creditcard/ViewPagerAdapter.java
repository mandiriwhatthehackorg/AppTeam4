package id.co.mandiri.onepushservices.ui.creditcard;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import id.co.mandiri.onepushservices.R;

import static android.content.Context.MODE_PRIVATE;
import static id.co.mandiri.onepushservices.Constant.MY_PREF_NAME;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item, null);
        ImageView imageView = view.findViewById(R.id.image);


        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_PREF_NAME, MODE_PRIVATE);
        Boolean isBlocked = sharedPreferences.getBoolean("isBlocked", false);

        if (isBlocked) {
            imageView.setImageDrawable(context.getResources().getDrawable(getImageBlockedAt(position)));
            view.findViewById(R.id.opacity).setVisibility(View.GONE);
            if (position==1) {
                view.findViewById(R.id.credit_card_status).setVisibility(View.VISIBLE);
                view.findViewById(R.id.detail).setVisibility(View.GONE);
                view.findViewById(R.id.opacity).setVisibility(View.VISIBLE);
                view.findViewById(R.id.activate_card).setVisibility(View.VISIBLE);
                view.findViewById(R.id.footer).setVisibility(View.GONE);
            }
        } else {
            imageView.setImageDrawable(context.getResources().getDrawable(getImageAt(position)));
            view.findViewById(R.id.opacity).setVisibility(View.GONE);
        }

        if (position==2) {
            view.findViewById(R.id.card_data).setVisibility(View.GONE);
            view.findViewById(R.id.content_card).setVisibility(View.GONE);
            view.findViewById(R.id.footer).setVisibility(View.GONE);
        }

        view.findViewById(R.id.block_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BlockCreditCardActivity.class);
                intent.putExtra("id_card", position);
                context.startActivity(intent);
            }
        });

        view.findViewById(R.id.activate_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showConfirmDialog();
            }
        });


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object view) {
        container.removeView((View) view);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return object == view;
    }

    @Override
    public int getCount() {
        return 3;
    }

    private int getImageAt(int position) {
        switch (position) {
            case 0:
                return R.drawable.platinum_card;
            case 1:
                return R.drawable.golden_card;
            default:
                return R.drawable.ic_add_card;
        }
    }

    private int getImageBlockedAt(int position) {
        switch (position) {
            case 0:
                return R.drawable.golden_card;
            case 1:
                return R.drawable.platinum_card;
            default:
                return R.drawable.ic_add_card;
        }
    }

    private void showConfirmDialog() {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_data_unavailable);

        Button confirmButton = dialog.findViewById(R.id.confirmation_button);
        Button cancelButton = dialog.findViewById(R.id.cancel_button);

        dialog.show();

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = context.getSharedPreferences(MY_PREF_NAME, MODE_PRIVATE).edit();
                editor.putBoolean("isBlocked", false);
                editor.apply();
                dialog.dismiss();
                context.startActivity(new Intent(context, DashboardCreditCardActivity.class));
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}
