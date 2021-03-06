package com.github.nfcforandroid.samples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockDialogFragment;
import com.actionbarsherlock.app.SherlockListFragment;
import com.github.nfcforandroid.samples.game.NfaGameWriter;
import com.github.nfcforandroid.samples.read.NfaReadActivity;
import com.github.nfcforandroid.samples.write.NfaBeamActivity;
import com.github.nfcforandroid.samples.write.NfaBeamMultiActivity;
import com.github.nfcforandroid.samples.write.NfaWriteActivity;

public class MainFragmentList extends SherlockListFragment {

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(getActivity(), //
				android.R.layout.simple_list_item_1, //
				getResources().getStringArray(R.array.list_action)));
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		switch (position) {
		case 0:
			startActivity(new Intent(getActivity(), NfaReadActivity.class));
			break;
		case 2:
			startActivity(new Intent(getActivity(), NfaWriteActivity.class));
			break;
		case 4:
			startActivity(new Intent(getActivity(), NfaBeamActivity.class));
			break;
		case 5:
			startActivity(new Intent(getActivity(), NfaBeamMultiActivity.class));
			break;
		case 6:
			startActivity(new Intent(getActivity(), NfaGameWriter.class));
			break;

		default:

			FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
			Fragment prev = getActivity().getSupportFragmentManager().findFragmentByTag("dialog");
			if (prev != null) {
				ft.remove(prev);
			}
			ft.addToBackStack(null);

			// Create and show the dialog.
			DialogFragment newFragment = MyDialogFragment.newInstance();
			newFragment.show(ft, "dialog");
			break;
		}
	}

	public static class MyDialogFragment extends SherlockDialogFragment {

		/**
		 * Create a new instance of MyDialogFragment, providing "num" as an argument.
		 */
		static MyDialogFragment newInstance() {
			MyDialogFragment f = new MyDialogFragment();
			return f;
		}

		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);

			// Pick a style based on the num.
			int style = DialogFragment.STYLE_NORMAL, theme = android.R.style.Theme_Light;

			setStyle(style, theme);
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View v = inflater.inflate(R.layout.fragment_dialog, container, false);
			// Watch for button clicks.
			Button button = (Button) v.findViewById(R.id.show);
			button.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// When button is clicked, call up to owning activity.
					MyDialogFragment.this.dismiss();
				}
			});

			return v;
		}
	}

}
