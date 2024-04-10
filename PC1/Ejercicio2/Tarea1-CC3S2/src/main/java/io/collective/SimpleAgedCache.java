package io.collective;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class SimpleAgedCache {

    private final Clock clock;
    private final Map<String, CacheEntry> cache;

    public SimpleAgedCache() {
        this(Clock.systemDefaultZone());
    }

    public SimpleAgedCache(Clock clock) {
        this.clock = clock;
        this.cache = new HashMap<>();
    }

    public void put(String key, Object value, long durationMillis) {
        Instant expirationTime = clock.instant().plusMillis(durationMillis);
        cache.put(key, new CacheEntry(value, expirationTime));
    }

    public Object get(String key) {
        CacheEntry entry = cache.get(key);
        if (entry != null && !isExpired(entry)) {
            return entry.getValue();
        }
        return null;
    }

    public boolean isEmpty() {
        return cache.isEmpty();
    }

    public int size() {
        return cache.size();
    }

    private boolean isExpired(CacheEntry entry) {
        return entry.getExpirationTime().isBefore(clock.instant());
    }

    private static class CacheEntry {
        private final Object value;
        private final Instant expirationTime;

        public CacheEntry(Object value, Instant expirationTime) {
            this.value = value;
            this.expirationTime = expirationTime;
        }

        public Object getValue() {
            return value;
        }

        public Instant getExpirationTime() {
            return expirationTime;
        }
    }
}
