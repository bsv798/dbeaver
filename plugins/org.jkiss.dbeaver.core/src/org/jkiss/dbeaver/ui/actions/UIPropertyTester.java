/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2019 Serge Rider (serge@jkiss.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jkiss.dbeaver.ui.actions;

import org.eclipse.core.expressions.PropertyTester;
import org.jkiss.dbeaver.DBeaverPreferences;
import org.jkiss.dbeaver.runtime.DBWorkbench;
import org.jkiss.dbeaver.ui.IActionConstants;

/**
 * UIPropertyTester
 */
public class UIPropertyTester extends PropertyTester {

    public static final String NAMESPACE = "org.jkiss.dbeaver.core.ui";
    // Toolbar visible on all perspectives
    public static final String PROP_TOOLBAR_VISIBLE = "toolbarVisible";

    @Override
    public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
        switch (property) {
            case PROP_TOOLBAR_VISIBLE:
                if (IActionConstants.TOOLBAR_DATABASE.equals(expectedValue)) {
                    return DBWorkbench.getPlatform().getPreferenceStore().getBoolean(DBeaverPreferences.TOOLBARS_SHOW_GENERAL_ALWAYS);
                } else if (IActionConstants.TOOLBAR_EDIT.equals(expectedValue)) {
                    return DBWorkbench.getPlatform().getPreferenceStore().getBoolean(DBeaverPreferences.TOOLBARS_SHOW_EDIT);
                }
        }
        return false;
    }

}
