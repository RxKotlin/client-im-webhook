//
//  ViewController.swift
//  MQTTDemo
//
//  Created by Jian Zhang on 8/10/16.
//  Copyright © 2016 Jian Zhang. All rights reserved.
//

import UIKit
import CocoaMQTT

class ViewController: UIViewController {
  let mqtt = CocoaMQTT(clientId: "hi", host: "localhost", port: 1883)
  
  override func viewDidLoad() {
    super.viewDidLoad()
  }
  
  @IBAction func onConnect() {
    mqtt.username = "testuser"
    mqtt.password = "passwd"
    mqtt.connect()
  }
  
  @IBAction func onSendMessage() {
    
  }
  
  @IBAction func onDisconnect() {
    mqtt.disconnect()
  }
}

