package com.gluegadget.hndroid;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewsAdapter extends ArrayAdapter<News> {
	int resource;
	
	public NewsAdapter(Context _context, int _resource, List<News> _items) {
		super(_context, _resource, _items);
		resource = _resource;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout newsView;
		News item = getItem(position);
		String title = item.getTitle();
		String score = item.getScore();
		String author = item.getAuthor();
		String domain = item.getDomain();
		
		if (convertView == null) {
			newsView = new LinearLayout(getContext());
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater vi = (LayoutInflater)getContext().getSystemService(inflater);
			vi.inflate(resource, newsView, true);
		} else {
			newsView = (LinearLayout) convertView;
		}
		
		TextView titleView = (TextView)newsView.findViewById(R.id.title);
		TextView scoreView = (TextView)newsView.findViewById(R.id.score);
		TextView authorView = (TextView)newsView.findViewById(R.id.author);
		titleView.setText(title);
		scoreView.setText(score);
		if (author == "")
			authorView.setText(author);
		else
			if (domain == "")
				authorView.setText("by " + author);
			else
				authorView.setText("by " + author + " from " + domain);
		return newsView;
	}
}