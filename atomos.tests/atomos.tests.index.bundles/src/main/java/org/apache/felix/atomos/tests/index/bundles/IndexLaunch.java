/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.felix.atomos.tests.index.bundles;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.felix.atomos.impl.runtime.base.AtomosRuntimeBase;
import org.apache.felix.atomos.launch.AtomosLauncher;
import org.osgi.framework.BundleException;
import org.osgi.framework.launch.Framework;

public class IndexLaunch
{
    private static volatile Framework framework;

    public static void main(String[] args) throws BundleException
    {
        long start = System.nanoTime();
        Map<String, String> config = AtomosLauncher.getConfiguration(args);
        config.put(AtomosRuntimeBase.ATOMOS_LOAD_INDEX_PROP,
            AtomosRuntimeBase.Index.FIRST.toString());
        framework = AtomosLauncher.launch(config);
        long total = System.nanoTime() - start;
        System.out.println("Total time: " + TimeUnit.NANOSECONDS.toMillis(total));
    }

    public static Framework getFramework()
    {
        return framework;
    }
}
