# GridView
Android GridView

#1. Simple GridView

GridView is a ViewGroup that displays items in a two-dimensional, scrollable grid. The grid items are automatically inserted to the layout using a ListAdapter.

This example is bad because we are doing the customization (component of the gridview) in only one activity. It's much better if you create an xml file.

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
![alt tag](https://github.com/BsParanoid/GridView/blob/master/screenshots/grid.png)

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
![alt tag](https://github.com/BsParanoid/GridView/blob/master/screenshots/gridPics.png)


#2. GridView text & pics

###MainActivity
```java
public class MainActivity extends AppCompatActivity
{
    GridView _grid;
    String[] _descriptionText = {
            "logo_1", "logo_2", "logo_3", "logo_4",
            "logo_5", "logo_6", "logo_7", "logo_8",
            "logo_9", "logo_10", "logo_11", "logo_1",
            "logo_2", "logo_3", "logo_4", "logo_5",
            "logo_6", "logo_7", "logo_8", "logo_9",
            "logo_10", "logo_11", "logo_1", "logo_2",
            "logo_3", "logo_4", "logo_5", "logo_6",
            "logo_7", "logo_8", "logo_9", "logo_10",
            "logo_11", "logo_1", "logo_2", "logo_3",
            "logo_4", "logo_5", "logo_6", "logo_7",
            "logo_8", "logo_9", "logo_10", "logo_11",
            "logo_1", "logo_2", "logo_3", "logo_4",
            "logo_5", "logo_6", "logo_7", "logo_8",
            "logo_9", "logo_10", "logo_11", "logo_1",
            "logo_2", "logo_3", "logo_4", "logo_5",
            "logo_6", "logo_7", "logo_8", "logo_9",
            "logo_10", "logo_11", "logo_1", "logo_2"
    } ;

    public Integer[] _ThumbIds = {
            R.drawable.logo_1, R.drawable.logo_2, R.drawable.logo_3, R.drawable.logo_4,
            R.drawable.logo_5, R.drawable.logo_6, R.drawable.logo_7, R.drawable.logo_8,
            R.drawable.logo_9, R.drawable.logo_10, R.drawable.logo_11, R.drawable.logo_1,
            R.drawable.logo_2, R.drawable.logo_3, R.drawable.logo_4, R.drawable.logo_5,
            R.drawable.logo_6, R.drawable.logo_7, R.drawable.logo_8, R.drawable.logo_9,
            R.drawable.logo_10, R.drawable.logo_11, R.drawable.logo_1, R.drawable.logo_2,
            R.drawable.logo_3, R.drawable.logo_4, R.drawable.logo_5, R.drawable.logo_6,
            R.drawable.logo_7, R.drawable.logo_8, R.drawable.logo_9, R.drawable.logo_10,
            R.drawable.logo_11, R.drawable.logo_1, R.drawable.logo_2, R.drawable.logo_3,
            R.drawable.logo_4, R.drawable.logo_5, R.drawable.logo_6, R.drawable.logo_7,
            R.drawable.logo_8, R.drawable.logo_9, R.drawable.logo_10, R.drawable.logo_11,
            R.drawable.logo_1, R.drawable.logo_2, R.drawable.logo_3, R.drawable.logo_4,
            R.drawable.logo_5, R.drawable.logo_6, R.drawable.logo_7, R.drawable.logo_8,
            R.drawable.logo_9, R.drawable.logo_10, R.drawable.logo_11, R.drawable.logo_1,
            R.drawable.logo_2, R.drawable.logo_3, R.drawable.logo_4, R.drawable.logo_5,
            R.drawable.logo_6, R.drawable.logo_7, R.drawable.logo_8, R.drawable.logo_9,
            R.drawable.logo_10, R.drawable.logo_11, R.drawable.logo_1, R.drawable.logo_2
    };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageAdapter adapter = new ImageAdapter(MainActivity.this, _descriptionText, _ThumbIds);
        _grid=(GridView)findViewById(R.id.simpleGrid);
        _grid.setAdapter(adapter);
        _grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "You Clicked at " +_descriptionText[+ position], Toast.LENGTH_SHORT).show();

            }
        });
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
    private Context _Context;
    private final String[] _descriptionText;
    private final Integer[] _Imageid;

    // Constructor
    public ImageAdapter(Context c, String[] descriptionText, Integer[] Imageid) {
        _Context = c;
        _descriptionText = descriptionText;
        _Imageid = Imageid;
    }

    public int getCount() {
        return _Imageid.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View grid;
        LayoutInflater inflater = (LayoutInflater) _Context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(_Context);
            grid = inflater.inflate(R.layout.component_of_grid, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setText(_descriptionText[position]);
            imageView.setImageResource(_Imageid[position]);
        } else {
            grid = (View) convertView;
        }
        return grid;
    }
}
```
###component_of_grid

```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:padding="5dp"
    android:weightSum="1">

    <TextView
        android:id="@+id/grid_text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="0dp"
        android:layout_below="@+id/grid_image"
        android:layout_centerHorizontal="true"
        android:textSize="9sp"
        android:layout_weight="4.30">
    </TextView>

    <ImageView
        android:id="@+id/grid_image"
        android:layout_width="150dp"
        android:layout_height="150dp"
        android:layout_alignParentTop="true">
    </ImageView>

</RelativeLayout>
```

