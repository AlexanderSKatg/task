package com.sk4atg89.alexander.jetruby.data.dribbble;

import com.sk4atg89.alexander.jetruby.BuildConfig;
import com.sk4atg89.alexander.jetruby.Constant;
import com.sk4atg89.alexander.jetruby.data.common.DribbbleImage;
import com.sk4atg89.alexander.jetruby.data.common.FakeException;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.realm.Realm;
import io.realm.RealmConfiguration.Builder;
import io.realm.exceptions.RealmException;

public class DribbbleDBManager {

    @Inject
    public DribbbleDBManager() {
    }

    public Completable saveImages(List<DribbbleImage> images) {

        Realm realm = null;

        try {
            realm = getRealmInstance();
            realm.executeTransaction(r -> r.copyToRealmOrUpdate(images));
            realm.close();
        } catch (Exception e) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace();
            }
        } finally {
            if (realm != null) {
                realm.close();
            }
        }

        return Completable.complete();
    }

    public Single<List<DribbbleImage>> getImages() {
        Realm realm = null;
        List<DribbbleImage> images = null;
        try {
            realm = getRealmInstance();
            images = realm
                    .copyFromRealm(realm
                            .where(DribbbleImage.class)
                            .findAll());
            realm.close();
        } catch (Exception e) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace();
            }
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
        if (images == null || images.isEmpty()){
            return Single.error(new FakeException("Turn internet on, and pull to refresh"));
        }

        return Single.just(images);
    }

    private Realm getRealmInstance() {
        try {
            return Realm.getDefaultInstance();
        } catch (RealmException exception) {
            Realm.deleteRealm(new Builder().name(Constant.REALM_DB_NAME).build());
            exception.printStackTrace();
            return Realm.getDefaultInstance();
        }
    }
}
