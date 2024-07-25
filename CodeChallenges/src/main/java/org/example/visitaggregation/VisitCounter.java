package org.example.visitaggregation;

import java.util.*;

public class VisitCounter {

    public Map<Long, Long> count(Map<String, UserStats>[] visits) {
        if (visits == null || visits.length == 0) {
            return Collections.emptyMap();
        }

        Map<Long, Long> result = new HashMap<>();

        Arrays.stream(visits)
                .filter(Objects::nonNull) // Filter out null maps
                .forEach(map -> map.entrySet().stream()
                        .filter(entry -> {
                            try {
                                Long.parseLong(entry.getKey());
                                return true;
                            } catch (NumberFormatException e) {
                                return false;
                            }
                        }) // Skip entries with keys that cannot be parsed to Long
                        .filter(entry -> entry.getValue() != null) // Skip entries with null UserStats
                        .filter(entry -> entry.getValue().getVisitCount().isPresent()) // Skip entries with empty visitCount
                        .forEach(entry -> {
                            Long userId = Long.parseLong(entry.getKey());
                            Long visitCount = entry.getValue().getVisitCount().get();
                            result.merge(userId, visitCount, Long::sum);
                        })
                );

        return result;
    }

    public static class UserStats {
        private Optional<Long> visitCount;

        public Optional<Long> getVisitCount() {
            return visitCount;
        }

        public void setVisitCount(Optional<Long> visitCount) {
            this.visitCount = visitCount;
        }
    }
}
