package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class CardPresenter extends Presenter {

    private static final String TAG = CardPresenter.class.getSimpleName();

    private static Context mContext;
    private static int CARD_WIDTH = 313;
    private static int CARD_HEIGHT = 176;

    static class ViewHolder extends Presenter.ViewHolder {

        private PicassoImageCardViewTarget mImageCardViewTarget;
        private Video mVideo;
        private Powerpoint mPowerPoint;
        private ImageCardView mCardView;
        private Drawable mDefaultCardImage;

        public ViewHolder(View view) {
            super(view);
            mCardView = (ImageCardView) view;
            mImageCardViewTarget = new PicassoImageCardViewTarget(mCardView);
            mDefaultCardImage = mContext.getResources().getDrawable(R.drawable.logo);
        }

        public void setVideo (Video video) {
            mVideo = video;
        }

        public Video getVideo() {
            return mVideo;
        }

        public void setPowerPoint (Powerpoint powerPoint) {
            mPowerPoint = powerPoint;
        }

        public Powerpoint getPowerPoint() { return mPowerPoint; }

        public ImageCardView getCardView() {
            return mCardView;
        }

        public Drawable getDefaultCardImage() {
            return mDefaultCardImage;
        }
    }

    public static class PicassoImageCardViewTarget implements Target {
        private ImageCardView mImageCardView;

        public PicassoImageCardViewTarget(ImageCardView imageCardView) {
            mImageCardView = imageCardView;
        }

        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
            Drawable bitmapDrawable = new BitmapDrawable(mContext.getResources(), bitmap);
            mImageCardView.setMainImage(bitmapDrawable);
        }

        @Override
        public void onBitmapFailed(Exception e, Drawable drawable) {
            mImageCardView.setMainImage(drawable);
        }

        @Override
        public void onPrepareLoad(Drawable drawable) {
            // Do nothing, default_background manager has its own transitions
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        Log.d(TAG, "onCreateViewHolder");
        mContext = parent.getContext();

        ImageCardView cardView = new ImageCardView(mContext);
        cardView.setFocusable(true);
        cardView.setFocusableInTouchMode(true);
        cardView.setBackgroundColor(mContext.getResources().getColor(R.color.indigo));
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        if (item instanceof Video) {
            Video movie = (Video) item;
            ((ViewHolder) viewHolder).setVideo(movie);

            Log.d(TAG, "onBindViewHolder");
            ((ViewHolder) viewHolder).mCardView.setTitleText(movie.getTitle());
            ((ViewHolder) viewHolder).mCardView.setContentText(movie.getDescription());
            ((ViewHolder) viewHolder).mCardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT);
            ((ViewHolder) viewHolder).mCardView.setMainImage(((ViewHolder) viewHolder).getDefaultCardImage());
        } else if (item instanceof Powerpoint) {
            Powerpoint powerpoint = (Powerpoint) item;
            ((ViewHolder) viewHolder).setPowerPoint(powerpoint);
            Log.d(TAG, "onBindViewHolder");
            ((ViewHolder) viewHolder).mCardView.setTitleText(powerpoint.getTitle());
            ((ViewHolder) viewHolder).mCardView.setContentText(powerpoint.getDescription());
            ((ViewHolder) viewHolder).mCardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT);
            ((ViewHolder) viewHolder).mCardView.setMainImage(((ViewHolder) viewHolder).getDefaultCardImage());
        }
    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        Log.d(TAG, "onUnbindViewHolder");
    }

}
