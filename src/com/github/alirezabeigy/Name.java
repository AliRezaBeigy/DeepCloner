package com.github.alirezabeigy;

class Name extends DeepCloner {
    private String first_name;
    private String last_name;

    private Name() {
    }

    private Name(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    String getFirstName() {
        return first_name;
    }

    String getLastName() {
        return last_name;
    }

    static class Builder {
        String first_name;
        String last_name;

        Builder first_name(String first_name) {
            this.first_name = first_name;
            return this;
        }

        Builder last_name(String last_name) {
            this.last_name = last_name;
            return this;
        }

        Name build() {
            return new Name(first_name, last_name);
        }
    }
}