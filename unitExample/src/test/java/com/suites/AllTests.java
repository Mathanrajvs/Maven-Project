package com.suites;

import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({"com.testcases.training"})
//@IncludePackages({"com.testcases.training.bank"})
@ExcludePackages("com.testcases.training.demo")
public class AllTests {

}
