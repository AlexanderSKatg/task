package com.sk4atg89.alexander.jetruby;

import android.support.test.runner.AndroidJUnit4;

import com.sk4atg89.alexander.jetruby.data.common.DribbbleImage;
import com.sk4atg89.alexander.jetruby.data.dribbble.DribbbleDBManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.TestObserver;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {


    private DribbbleDBManager dbManager;

    @Test
    public void useAppContext() throws Exception {
        dbManager = new DribbbleDBManager();
        List<DribbbleImage> images = new ArrayList<>();
        DribbbleImage d1 = new DribbbleImage();
        d1.setDescribtion("description example");
        d1.setTitle("title example");
        d1.setImageUrl("https://wpapers.ru/wallpapers/3d/Rendering/8590/PREV_%D0%9D%D0%B5%D0%BE%D0%BD%D0%BE%D0%B2%D0%B0%D1%8F-%D0%BA%D0%BE%D1%88%D0%BA%D0%B0.jpg");

        DribbbleImage d2 = new DribbbleImage();
        d2.setDescribtion("description example");
        d2.setTitle("title example");
        d2.setImageUrl("http://www.radionetplus.ru/uploads/posts/2013-05/1369460621_panda-26.jpg");

        DribbbleImage d3 = new DribbbleImage();
        d3.setDescribtion("description example");
        d3.setTitle("title example");
        d3.setImageUrl("http://www.cruzo.net/user/images/k/6befd660cb87fdaec9c9c6908a10523f_136.jpg");

        DribbbleImage d4 = new DribbbleImage();
        d4.setDescribtion("description exampldescription exampldescription exampldescription exampldescription example");
        d4.setTitle("title example title example title example title example");
        d4.setImageUrl("http://www.cruzo.net/user/images/k/6befd660cb87fdaec9c9c6908a10523f_136.jpg");

        images.add(d1);
        images.add(d2);
        images.add(d3);
        images.add(d4);
        TestObserver<Void> testObserver =
                dbManager.saveImages(images)
                        .test();

        testObserver.assertComplete()
                .assertNoErrors();


        TestObserver<List<DribbbleImage>> testObserver1 =
                dbManager.getImages()
                        .test();

        testObserver1
                .assertValue(dribbbleImages -> dribbbleImages.size() >=3)
                .assertNoErrors();
    }
}
