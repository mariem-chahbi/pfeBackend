package com.creche.crecheapp.model;

public enum ActivityType {
        GROSS_MOTOR("Gross motor activities"),
        FINE_MOTOR("Fine motor activities"),
        COGNITIVE("Cognitive activities"),
        SENSORY("Sensory activities");

        private final String name;

        ActivityType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }



