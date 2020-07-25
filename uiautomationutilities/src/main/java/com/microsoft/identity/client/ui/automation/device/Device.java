package com.microsoft.identity.client.ui.automation.device;

import androidx.annotation.NonNull;

import com.microsoft.identity.client.ui.automation.device.settings.GoogleSettings;
import com.microsoft.identity.client.ui.automation.device.settings.ISettings;
import com.microsoft.identity.client.ui.automation.device.settings.SamsungSettings;

import lombok.Getter;

/**
 * This class represents a device under test during UI Automation
 */
@Getter
public class Device {

    private final String manufacturer;
    private final String model;
    private final int apiLevel;
    private final ISettings settings;

    public Device(@NonNull final String manufacturer,
                  @NonNull final String model,
                  final int apiLevel) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.apiLevel = apiLevel;
        this.settings = getSupportedDeviceSettings(manufacturer, model);
    }

    public Device(@NonNull final String manufacturer,
                  @NonNull final String model,
                  final int apiLevel,
                  @NonNull final ISettings settings) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.apiLevel = apiLevel;
        this.settings = settings;
    }

    private static ISettings getSupportedDeviceSettings(@NonNull final String manufacturer,
                                                        @NonNull final String model) {
        // each device could have its own version of settings depending on make, model & apiLevel
        // For simplicity right now, we just have two configurations depending on manufacturer
        if ("SAMSUNG".equalsIgnoreCase(manufacturer)) {
            return new SamsungSettings();
        }

        return new GoogleSettings();
    }
}
