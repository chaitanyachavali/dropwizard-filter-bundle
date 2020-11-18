/*
 * Copyright 2020 chaitanyachavali <chavalichaithanyachinna@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.chaitanyachavali.dropwizard;

import com.chaitanyachavali.dropwizard.enums.FilterMode;
import com.chaitanyachavali.dropwizard.features.ReadWriteDynamicFeature;
import io.dropwizard.Configuration;
import io.dropwizard.ConfiguredBundle;
import io.dropwizard.setup.Environment;

public abstract class ResourceFilterBundle<T extends Configuration> implements ConfiguredBundle<T> {

  public abstract FilterMode withMode();

  public void run(T configuration, Environment environment) {
    FilterMode effectiveMode = withMode() == null ? FilterMode.READ_WRITE : withMode();
    environment.jersey().register(new ReadWriteDynamicFeature(effectiveMode));
  }

}
