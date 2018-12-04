package com.tanat.testgrechko.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tanat.testgrechko.R;
import com.tanat.testgrechko.model.Place;
import com.tanat.testgrechko.model.PlaceGroupSchema;

import java.util.ArrayList;
import java.util.List;

public class ExpandableAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<PlaceGroupSchema> groupList;

    public ExpandableAdapter(@NonNull Context context, List<PlaceGroupSchema> groupList) {
        this.context = context;
        this.groupList = groupList;
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        List<Place> placeArrayList = groupList.get(groupPosition).getPlaces();
        return placeArrayList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groupList.get(groupPosition).getPlaces().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    public class GroupViewHolder {
        public TextView labelTextView;

        public GroupViewHolder(View view) {
            labelTextView = (TextView) view.findViewById(R.id.labelTextView);
        }
    }

    public class ChildrenViewHolder {
        public LinearLayout itemLayout;

        public TextView nameTextView;
        public TextView codeTextView;

        public ChildrenViewHolder(View view) {
            itemLayout = (LinearLayout) view.findViewById(R.id.itemLayout);
            nameTextView = (TextView) view.findViewById(R.id.nameTextView);
            codeTextView = (TextView) view.findViewById(R.id.codeTextView);
        }
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        PlaceGroupSchema entity = groupList.get(groupPosition);
        final GroupViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_group_expandable_list, parent, false);
            viewHolder = new GroupViewHolder(convertView);
            convertView.setTag(R.id.group_view, viewHolder);
        } else {
            viewHolder = (GroupViewHolder) convertView.getTag(R.id.group_view);
        }

        viewHolder.labelTextView.setText(entity.getName());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Place entity = groupList.get(groupPosition).getPlaces().get(childPosition);

        final ChildrenViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_raw_material_list, parent, false);
            viewHolder = new ChildrenViewHolder(convertView);
            convertView.setTag(R.id.selected_view, viewHolder);
        } else {
            viewHolder = (ChildrenViewHolder) convertView.getTag(R.id.selected_view);
        }

        final String name = entity.getName();
        final String code = entity.getCode();

        viewHolder.nameTextView.setText(name);
        viewHolder.codeTextView.setText(code);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
