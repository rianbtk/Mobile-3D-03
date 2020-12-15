package com.rian.latihanretrofit.databinding;
import com.rian.latihanretrofit.R;
import com.rian.latihanretrofit.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.idLabel, 4);
        sViewsWithIds.put(R.id.urlLabel, 5);
        sViewsWithIds.put(R.id.textView3, 6);
        sViewsWithIds.put(R.id.deskripsiLabel, 7);
        sViewsWithIds.put(R.id.userEdit, 8);
        sViewsWithIds.put(R.id.cariBtn, 9);
        sViewsWithIds.put(R.id.loadingBar, 10);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[9]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[1]
            , (android.widget.ProgressBar) bindings[10]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[2]
            , (android.widget.EditText) bindings[8]
            );
        this.deskripsiText.setTag(null);
        this.idText.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.urlText.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.repo == variableId) {
            setRepo((com.rian.latihanretrofit.models.Repo) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setRepo(@Nullable com.rian.latihanretrofit.models.Repo Repo) {
        this.mRepo = Repo;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.repo);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String repoHtmlUrl = null;
        java.lang.Integer repoId = null;
        java.lang.String stringValueOfRepoId = null;
        java.lang.String repoDescription = null;
        int androidxDatabindingViewDataBindingSafeUnboxRepoId = 0;
        com.rian.latihanretrofit.models.Repo repo = mRepo;

        if ((dirtyFlags & 0x3L) != 0) {



                if (repo != null) {
                    // read repo.htmlUrl
                    repoHtmlUrl = repo.getHtmlUrl();
                    // read repo.id
                    repoId = repo.getId();
                    // read repo.description
                    repoDescription = repo.getDescription();
                }


                // read androidx.databinding.ViewDataBinding.safeUnbox(repo.id)
                androidxDatabindingViewDataBindingSafeUnboxRepoId = androidx.databinding.ViewDataBinding.safeUnbox(repoId);


                // read String.valueOf(androidx.databinding.ViewDataBinding.safeUnbox(repo.id))
                stringValueOfRepoId = java.lang.String.valueOf(androidxDatabindingViewDataBindingSafeUnboxRepoId);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.deskripsiText, repoDescription);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.idText, stringValueOfRepoId);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.urlText, repoHtmlUrl);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): repo
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}