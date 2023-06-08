package dev.gretron.spaceapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Value;

import java.util.List;

/**
 * @param <T> The Data object type
 */
@Value
public class PaginatedEntity<T> {

    public static final String DEFAULT_FIRST_PAGE = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";

    private List<T> entities;
    private int page;
    private int pageSize;
    private long entitiesCount;

    @JsonProperty
    public long totalPages() {
        if (pageSize > 0) {
            double count = (double) entitiesCount;

            return (long) Math.ceil(count / pageSize);
        } else
            return 0;

    }

    @JsonProperty
    public boolean first() {
        return page == Integer.parseInt(DEFAULT_FIRST_PAGE);
    }

    @JsonProperty
    public boolean last() {
        return (page + 1) * pageSize >= entitiesCount;
    }
}
