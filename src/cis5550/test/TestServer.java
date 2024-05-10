package cis5550.test;

import static cis5550.webserver.Server.*;
import cis5550.webserver.Session;

public class TestServer {
    public static void main(String args[]) throws Exception {
    securePort(443);
    get("/", (req,res) -> { return "Hello World - this is Atharva Bankar"; });
  }
}
