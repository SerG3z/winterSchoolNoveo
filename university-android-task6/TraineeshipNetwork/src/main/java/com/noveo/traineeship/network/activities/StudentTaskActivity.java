package com.noveo.traineeship.network.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import com.noveo.traineeship.network.R;
import com.noveo.traineeship.network.adapter.NewsAdapter;
import com.noveo.traineeship.network.api.Api;
import com.noveo.traineeship.network.models.News;
import com.noveo.traineeship.network.services.ServiceFactory;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class StudentTaskActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_task);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final NewsAdapter mainNewsAdapter = new NewsAdapter();
        recyclerView.setAdapter(mainNewsAdapter);


        mainNewsAdapter.clear();

        Api service = ServiceFactory.createRetrofitService(Api.class, Api.END_POINT);

        List<String> idList = new ArrayList<String>();
        idList.add("4c85938e-ef30-11e5-9e46-0050568859de");
        idList.add("d3ba518e-ef51-11e5-9e46-0050568859de");
        idList.add("101d6190-ef41-11e5-9e46-0050568859de");
        idList.add("71df5ba6-ef49-11e5-9e46-0050568859de");
        idList.add("356be656-ef5a-11e5-9e46-0050568859de");

        String str = "356be656-ef5a-11e5-9e46-0050568859de";
//        for (String str: idList) {
            service.listNews()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<News>() {
                        @Override
                        public final void onCompleted() {
                            // do nothing
                        }

                        @Override
                        public final void onError(Throwable e) {
                            Log.e("test error", e.getMessage());
                        }

                        @Override
                        public final void onNext(News response) {
                            Log.e("!!!!!!!!!!!!!!!!!!!", "ооооо да!!!");
                            mainNewsAdapter.addData(response);
                        }
                    });
//        }

    }


}
