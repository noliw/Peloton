package com.nolawiworkineh.peloton

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class PelotonApp : Application()

/*
* THis is the root of the Di graph we are basically telling hilt
* to setup all the code necessary to so that hilt can setup the code
* to make our Di work for the entire application
*
* Enables Hilt: @HiltAndroidApp sets up the root dependency injection container.

Extends Application: Ensures this class runs before any Activity or ViewModel.

App-wide setup: Ideal for initializing global dependencies or services.
* */