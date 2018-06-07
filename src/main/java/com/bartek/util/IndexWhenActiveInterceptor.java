package com.bartek.util;

import com.bartek.domain.App;
import org.hibernate.search.indexes.interceptor.EntityIndexingInterceptor;
import org.hibernate.search.indexes.interceptor.IndexingOverride;

public class IndexWhenActiveInterceptor implements EntityIndexingInterceptor<App> {

    public IndexingOverride onAdd(App entity) {
        if (entity.isActive()) {
            return IndexingOverride.APPLY_DEFAULT;
        }
        return IndexingOverride.SKIP;
    }

    public IndexingOverride onUpdate(App entity) {
        if (entity.isActive()) {
            return IndexingOverride.UPDATE;
        } else {
            return IndexingOverride.REMOVE;
        }
    }

    public IndexingOverride onDelete(App entity) {
        return IndexingOverride.APPLY_DEFAULT;
    }

    public IndexingOverride onCollectionUpdate(App entity) {
        return onUpdate(entity);
    }

}
