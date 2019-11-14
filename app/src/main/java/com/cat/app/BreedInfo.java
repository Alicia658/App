package com.cat.app;

import java.util.List;

public class BreedInfo {



    private String id;
    private String url;
    private int width;
    private int height;
    private List<ItemBreed> breeds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<ItemBreed> getBreeds() {
        return breeds;
    }

    public void setBreeds(List<ItemBreed> breeds) {
        this.breeds = breeds;
    }

    public static class ItemBreed {


        private WeightBean weight;
        private String id;
        private String name;
        private String cfa_url;
        private String vetstreet_url;
        private String vcahospitals_url;
        private String temperament;
        private String origin;
        private String country_codes;
        private String country_code;
        private String description;
        private String life_span;
        private int indoor;
        private int lap;
        private String alt_names;
        private int adaptability;
        private int affection_level;
        private int child_friendly;
        private int dog_friendly;
        private int energy_level;
        private int grooming;
        private int health_issues;
        private int intelligence;
        private int shedding_level;
        private int social_needs;
        private int stranger_friendly;
        private int vocalisation;
        private int experimental;
        private int hairless;
        private int natural;
        private int rare;
        private int rex;
        private int suppressed_tail;
        private int short_legs;
        private String wikipedia_url;
        private int hypoallergenic;

        public WeightBean getWeight() {
            return weight;
        }

        public void setWeight(WeightBean weight) {
            this.weight = weight;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCfa_url() {
            return cfa_url;
        }

        public void setCfa_url(String cfa_url) {
            this.cfa_url = cfa_url;
        }

        public String getVetstreet_url() {
            return vetstreet_url;
        }

        public void setVetstreet_url(String vetstreet_url) {
            this.vetstreet_url = vetstreet_url;
        }

        public String getVcahospitals_url() {
            return vcahospitals_url;
        }

        public void setVcahospitals_url(String vcahospitals_url) {
            this.vcahospitals_url = vcahospitals_url;
        }

        public String getTemperament() {
            return temperament;
        }

        public void setTemperament(String temperament) {
            this.temperament = temperament;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getCountry_codes() {
            return country_codes;
        }

        public void setCountry_codes(String country_codes) {
            this.country_codes = country_codes;
        }

        public String getCountry_code() {
            return country_code;
        }

        public void setCountry_code(String country_code) {
            this.country_code = country_code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLife_span() {
            return life_span;
        }

        public void setLife_span(String life_span) {
            this.life_span = life_span;
        }

        public int getIndoor() {
            return indoor;
        }

        public void setIndoor(int indoor) {
            this.indoor = indoor;
        }

        public int getLap() {
            return lap;
        }

        public void setLap(int lap) {
            this.lap = lap;
        }

        public String getAlt_names() {
            return alt_names;
        }

        public void setAlt_names(String alt_names) {
            this.alt_names = alt_names;
        }

        public int getAdaptability() {
            return adaptability;
        }

        public void setAdaptability(int adaptability) {
            this.adaptability = adaptability;
        }

        public int getAffection_level() {
            return affection_level;
        }

        public void setAffection_level(int affection_level) {
            this.affection_level = affection_level;
        }

        public int getChild_friendly() {
            return child_friendly;
        }

        public void setChild_friendly(int child_friendly) {
            this.child_friendly = child_friendly;
        }

        public int getDog_friendly() {
            return dog_friendly;
        }

        public void setDog_friendly(int dog_friendly) {
            this.dog_friendly = dog_friendly;
        }

        public int getEnergy_level() {
            return energy_level;
        }

        public void setEnergy_level(int energy_level) {
            this.energy_level = energy_level;
        }

        public int getGrooming() {
            return grooming;
        }

        public void setGrooming(int grooming) {
            this.grooming = grooming;
        }

        public int getHealth_issues() {
            return health_issues;
        }

        public void setHealth_issues(int health_issues) {
            this.health_issues = health_issues;
        }

        public int getIntelligence() {
            return intelligence;
        }

        public void setIntelligence(int intelligence) {
            this.intelligence = intelligence;
        }

        public int getShedding_level() {
            return shedding_level;
        }

        public void setShedding_level(int shedding_level) {
            this.shedding_level = shedding_level;
        }

        public int getSocial_needs() {
            return social_needs;
        }

        public void setSocial_needs(int social_needs) {
            this.social_needs = social_needs;
        }

        public int getStranger_friendly() {
            return stranger_friendly;
        }

        public void setStranger_friendly(int stranger_friendly) {
            this.stranger_friendly = stranger_friendly;
        }

        public int getVocalisation() {
            return vocalisation;
        }

        public void setVocalisation(int vocalisation) {
            this.vocalisation = vocalisation;
        }

        public int getExperimental() {
            return experimental;
        }

        public void setExperimental(int experimental) {
            this.experimental = experimental;
        }

        public int getHairless() {
            return hairless;
        }

        public void setHairless(int hairless) {
            this.hairless = hairless;
        }

        public int getNatural() {
            return natural;
        }

        public void setNatural(int natural) {
            this.natural = natural;
        }

        public int getRare() {
            return rare;
        }

        public void setRare(int rare) {
            this.rare = rare;
        }

        public int getRex() {
            return rex;
        }

        public void setRex(int rex) {
            this.rex = rex;
        }

        public int getSuppressed_tail() {
            return suppressed_tail;
        }

        public void setSuppressed_tail(int suppressed_tail) {
            this.suppressed_tail = suppressed_tail;
        }

        public int getShort_legs() {
            return short_legs;
        }

        public void setShort_legs(int short_legs) {
            this.short_legs = short_legs;
        }

        public String getWikipedia_url() {
            return wikipedia_url;
        }

        public void setWikipedia_url(String wikipedia_url) {
            this.wikipedia_url = wikipedia_url;
        }

        public int getHypoallergenic() {
            return hypoallergenic;
        }

        public void setHypoallergenic(int hypoallergenic) {
            this.hypoallergenic = hypoallergenic;
        }

        public static class WeightBean {
            /**
             * imperial : 8 - 15
             * metric : 4 - 7
             */

            private String imperial;
            private String metric;

            public String getImperial() {
                return imperial;
            }

            public void setImperial(String imperial) {
                this.imperial = imperial;
            }

            public String getMetric() {
                return metric;
            }

            public void setMetric(String metric) {
                this.metric = metric;
            }
        }
    }
}
