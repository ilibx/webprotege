package edu.stanford.bmir.protege.web.server.dispatch.actions;

import edu.stanford.bmir.protege.web.shared.dispatch.ProjectAction;
import edu.stanford.bmir.protege.web.shared.project.ProjectId;
import org.semanticweb.owlapi.model.OWLAxiom;

import javax.annotation.Nonnull;

import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 18 Apr 2018
 *
 * This is a server side action.  It won't work on the client.
 */
public class AddAxiomsAction implements ProjectAction<AddAxiomsResult> {

    @Nonnull
    private final ProjectId projectId;

    @Nonnull
    private final Stream<OWLAxiom> axioms;

    @Nonnull
    private final String commitMessage;

    public AddAxiomsAction(@Nonnull ProjectId projectId,
                           @Nonnull Stream<OWLAxiom> axioms,
                           @Nonnull String commitMessage) {
        this.projectId = checkNotNull(projectId);
        this.axioms = checkNotNull(axioms);
        this.commitMessage = checkNotNull(commitMessage);
    }


    @Nonnull
    @Override
    public ProjectId getProjectId() {
        return projectId;
    }

    @Nonnull
    public Stream<OWLAxiom> getAxioms() {
        return axioms;
    }

    @Nonnull
    public String getCommitMessage() {
        return commitMessage;
    }
}
