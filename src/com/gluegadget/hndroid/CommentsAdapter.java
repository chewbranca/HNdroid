package com.gluegadget.hndroid;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CommentsAdapter extends ArrayAdapter<Comment> {
	int resource;
	
	public CommentsAdapter(Context _context, int _resource, List<Comment> _items) {
		super(_context, _resource, _items);
		resource = _resource;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout newsView;
		Comment item = getItem(position);
		String title = item.getTitle();
		String score = item.getScore();
		String author = item.getAuthor();
		
		if (convertView == null) {
			newsView = new LinearLayout(getContext());
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater vi = (LayoutInflater)getContext().getSystemService(inflater);
			vi.inflate(resource, newsView, true);
		} else {
			newsView = (LinearLayout) convertView;
		}
		
		TextView titleView = (TextView)newsView.findViewById(R.id.title);
		titleView.setPadding(item.getPadding() + 1, 10, 10, 10);
		TextView scoreView = (TextView)newsView.findViewById(R.id.score);
		TextView authorView = (TextView)newsView.findViewById(R.id.author);
		titleView.setText(title);
		scoreView.setText(score);
		if (author == "")
			authorView.setText(author);
		else
			authorView.setText("by " + author);

		return newsView;
	}
}
