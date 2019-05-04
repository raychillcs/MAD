package com.example.finalexam;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.finalexam.dummy.DummyContent;

import java.util.List;
import java.util.UUID;

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ItemListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout layout = new LinearLayout(ItemListActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                final EditText idEditText = new EditText(ItemListActivity.this);
                idEditText.setHint("Restaurant ID");
                layout.addView(idEditText);
                final EditText nameEditText = new EditText(ItemListActivity.this);
                nameEditText.setHint("Restaurant Name");
                layout.addView(nameEditText);
                final EditText urlEditText = new EditText(ItemListActivity.this);
                urlEditText.setHint("Restaurant URL");
                layout.addView(urlEditText);

                AlertDialog.Builder dialog = new AlertDialog.Builder(ItemListActivity.this);
                dialog.setTitle("Add Restaurant");
                dialog.setView(layout);
                dialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //get book name entered
                        final String newIDText = idEditText.getText().toString();
                        final String newNameText = nameEditText.getText().toString();
                        final String newURLText = urlEditText.getText().toString();
                        if (!newNameText.isEmpty()) {
                            addRestaurant(newIDText, newNameText, newURLText);
                        } }
                });
                dialog.setNegativeButton("Cancel", null); dialog.show();
            }
        });

        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }

        View recyclerView = findViewById(R.id.item_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
//        DummyContent.jsonParse();
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this, DummyContent.ITEMS, mTwoPane));
    }

    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final ItemListActivity mParentActivity;
        private final List<DummyContent.DummyItem> mValues;
        private final boolean mTwoPane;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DummyContent.DummyItem item = (DummyContent.DummyItem) view.getTag();
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(ItemDetailFragment.ARG_ITEM_ID, item.id);
                    ItemDetailFragment fragment = new ItemDetailFragment();
                    fragment.setArguments(arguments);
                    mParentActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.item_detail_container, fragment)
                            .commit();
                } else {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, ItemDetailActivity.class);
                    intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, item.id);

                    context.startActivity(intent);
                }
            }
        };

        SimpleItemRecyclerViewAdapter(ItemListActivity parent,
                                      List<DummyContent.DummyItem> items,
                                      boolean twoPane) {
            mValues = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mIdView.setText(mValues.get(position).id);
            holder.mContentView.setText(mValues.get(position).name);

            holder.itemView.setTag(mValues.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);

//            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int position = (Integer) viewHolder.hasRead.getTag();
//                    Book book = getItem(position);
//                    activity.editBook(book.getId());
//                }
//            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mIdView;
            final TextView mContentView;

            ViewHolder(View view) {
                super(view);
                mIdView = (TextView) view.findViewById(R.id.id_text);
                mContentView = (TextView) view.findViewById(R.id.content);
            }
        }
    }

    public void addRestaurant(final String newId, final String newName, final String newURL){
        DummyContent.addItem(new DummyContent.DummyItem(newId, newName, newURL));
    }

//    private void changeRestaurant(final String changedId, final String changedName, final String changedURL){
//        DummyContent.DummyItem item = DummyContent.ITEM_MAP.get(changedId);
//        DummyContent.addItem(new DummyContent.DummyItem(changedId, changedName, changedURL));
//    }

//    public void editRestaurant(final String restId){
//        LinearLayout layout = new LinearLayout(ItemListActivity.this);
//        layout.setOrientation(LinearLayout.VERTICAL);
//
//        DummyContent.DummyItem item = DummyContent.ITEM_MAP.get(restId);
//
//        //create edit texts and add to layout
//        final EditText idEditText = new EditText(ItemListActivity.this);
//        idEditText.setText(DummyContent.DummyItem.getId());
//        layout.addView(idEditText);
//        final EditText nameEditText = new EditText(ItemListActivity.this);
//        nameEditText.setText(DummyContent.DummyItem.getName());
//        layout.addView(nameEditText);
//        final EditText urlEditText = new EditText(ItemListActivity.this);
//        urlEditText.setText(DummyContent.DummyItem.getUrl());
//        layout.addView(urlEditText);
//
//        AlertDialog.Builder dialog = new AlertDialog.Builder(ItemListActivity.this);
//        dialog.setTitle("Edit Book");
//        dialog.setView(layout);
//        dialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                final String updatedName = nameEditText.getText().toString();
//                final String updatedUrl = urlEditText.getText().toString();
//                if(!updatedName.isEmpty()) {
//                    changeRestaurant(restId, updatedName, updatedUrl);
//                }
//            }
//        });
//        dialog.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                deleteRestaurant(restId);
//                deleteRestaurant(restId);
//            }
//        });
//        dialog.create();
//        dialog.show();
//    }
//
//    private void deleteRestaurant(final String restId){
//    }
}
