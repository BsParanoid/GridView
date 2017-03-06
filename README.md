# GridView
Android GridView

#1. Simple GridView

GridView is a ViewGroup that displays items in a two-dimensional, scrollable grid. The grid items are automatically inserted to the layout using a ListAdapter.

[GridView android dev](https://developer.android.com/reference/android/widget/GridView.html)

###MainActivity
```java

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView) findViewById(R.id.simpleGrid);
        gridview.setAdapter(new ImageAdapter(this)); /* That will set the data into the GridView */
    }
}
```

###activity_main
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/activity_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context="com.github.bsparanoid.simplegridview.MainActivity">

    <GridView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/simpleGrid"
        android:columnWidth="90dp"                                         
        android:verticalSpacing="10dp"
        android:horizontalSpacing="10dp"
        android:stretchMode="columnWidth"
        android:gravity="center"
        android:numColumns="auto_fit"/>
</RelativeLayout>
```


###ImageAdapter
```java
public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300)); /* case grid size 300x300 */
            imageView.setScaleType(ImageView.ScaleType.FIT_START); /* position of the image in the case */
            imageView.setPadding(8, 8, 8, 8); /* space -> top bottom right left of an case */
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    /* Keep all Images in array */
    public Integer[] mThumbIds = {
            R.drawable.logo_1, R.drawable.logo_11, R.drawable.logo_2, R.drawable.logo_10,
            R.drawable.logo_3, R.drawable.logo_9, R.drawable.logo_4, R.drawable.logo_8,
            R.drawable.logo_5, R.drawable.logo_7, R.drawable.logo_6, R.drawable.logo_6,
            R.drawable.logo_7, R.drawable.logo_5, R.drawable.logo_8, R.drawable.logo_4,
            R.drawable.logo_9, R.drawable.logo_3, R.drawable.logo_10, R.drawable.logo_2,
            R.drawable.logo_11, R.drawable.logo_1, R.drawable.logo_1, R.drawable.logo_11,
            R.drawable.logo_2, R.drawable.logo_10, R.drawable.logo_3, R.drawable.logo_9,
            R.drawable.logo_4, R.drawable.logo_8, R.drawable.logo_5, R.drawable.logo_7,
            R.drawable.logo_6, R.drawable.logo_6, R.drawable.logo_7, R.drawable.logo_5,
            R.drawable.logo_8, R.drawable.logo_4, R.drawable.logo_9, R.drawable.logo_3,
            R.drawable.logo_10, R.drawable.logo_2, R.drawable.logo_11, R.drawable.logo_1,
            R.drawable.logo_1, R.drawable.logo_11, R.drawable.logo_2, R.drawable.logo_10,
            R.drawable.logo_3, R.drawable.logo_9, R.drawable.logo_4, R.drawable.logo_8,
            R.drawable.logo_5, R.drawable.logo_7, R.drawable.logo_6, R.drawable.logo_6,
            R.drawable.logo_7, R.drawable.logo_5, R.drawable.logo_8, R.drawable.logo_4,
            R.drawable.logo_9, R.drawable.logo_3, R.drawable.logo_10, R.drawable.logo_2,
            R.drawable.logo_11, R.drawable.logo_1, R.drawable.logo_2, R.drawable.logo_10
    };
}
```


