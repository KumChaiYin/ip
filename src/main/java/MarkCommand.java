public class MarkCommand extends Command{
    private int taskId;
    public MarkCommand(int taskId) {
        this.taskId = taskId;
    }

    public void execute(TaskList tasks, Ui ui) throws AiChanException {
        int size = tasks.getSize();
        if (taskId < 1 || taskId > size) throw new AiChanException("Please provide a valid task number.");
        Task task = tasks.getTask(taskId);
        task.mark();
        ui.showMessage("Nice! I've marked this task as done:\n"
                + task.toString());
    }
    @Override
    public boolean isExit(){
        return false;
    }
}
