package com.nischal.threads.resourceprotection;

@FunctionalInterface
public interface Transaction {
    void process(Account account);
}
