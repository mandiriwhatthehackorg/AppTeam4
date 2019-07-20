package id.co.mandiri.onepushservices.ui.creditcard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import id.co.mandiri.onepushservices.R;

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
        imageView.setImageDrawable(context.getResources().getDrawable(getImageAt(position)));

        if (position==2) {
            view.findViewById(R.id.content_card).setVisibility(View.GONE);
        }

        view.findViewById(R.id.block_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BlockCreditCardActivity.class);
                intent.putExtra("id_card", position);
                context.startActivity(intent);
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
}
