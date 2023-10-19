package use_case.clear_users;

// TODO Complete me
import entity.User;
import java.util.List;

public class ClearInteractor implements ClearInputBoundary {

    final ClearUserDataAccessInterface userDataAccessObject;
    final ClearOutputBoundary clearPresenter;
    public ClearInteractor(ClearUserDataAccessInterface clearUserDataAccessInterface,
                           ClearOutputBoundary clearOutputBoundary) {
        this.userDataAccessObject = clearUserDataAccessInterface;
        this.clearPresenter = clearOutputBoundary;
    }

    @Override
    public void execute() {
        List<String> usernames = userDataAccessObject.extractUsers();
        String result = "";

        for (String username : usernames) {
            result += username + "\n";
        }

        ClearOutputData clearOutputData = new ClearOutputData(result);
        clearPresenter.prepareClearView(clearOutputData);
    }
}
